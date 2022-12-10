package precourse.week3.controller;

import precourse.week3.domain.lottomaker.LottoMaker;
import precourse.week3.domain.lottomaker.LottoNumberGenerator;
import precourse.week3.domain.lottostatistic.LottoStatistic;
import precourse.week3.domain.lottostore.LottoTicketsStore;
import precourse.week3.domain.lottoticket.LottoTickets;
import precourse.week3.domain.lottowinningnumber.LottoWinningNumbersMaker;
import precourse.week3.domain.money.Money;
import precourse.week3.domain.result.LottoResults;
import precourse.week3.domain.winnerchecker.WinnerChecker;
import precourse.week3.view.InputView;
import precourse.week3.view.Message;
import precourse.week3.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runLottoProgramMain() {
        try {
            runLottoProgram();
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private void runLottoProgram() {
        Money money = new Money(inputView.readPayment());
        LottoTicketsStore lottoTicketsStore = new LottoTicketsStore(new LottoMaker(new LottoNumberGenerator()));
        LottoTickets lottoTickets = lottoTicketsStore.sellLottoTickets(money);
        printLottoTickets(lottoTickets);
        List<Integer> numbers = inputView.readWinningNumbers();
        int number = inputView.readBonusNumber();
        LottoWinningNumbersMaker lottoWinningNumbersMaker = new LottoWinningNumbersMaker();
        WinnerChecker winnerChecker = new WinnerChecker(lottoWinningNumbersMaker.createLottoWinningNumbers(numbers, number));
        LottoResults lottoResults = winnerChecker.check(lottoTickets);
        printStatistics(lottoResults);
    }

    private void printStatistics(LottoResults lottoResults) {
        LottoStatistic statistic = lottoResults.createLottoStatistic();
        outputView.printStatistics(statistic);
    }

    private void printLottoTickets(LottoTickets lottoTickets) {
        String message = lottoTickets.toMessage(Message.LOTTO_DELIMITER.getMessage(), Message.LOTTO_PREFIX.getMessage(), Message.LOTTO_SUFFIX.getMessage());
        outputView.printLottoTickets(lottoTickets.size(), message);
    }
}
