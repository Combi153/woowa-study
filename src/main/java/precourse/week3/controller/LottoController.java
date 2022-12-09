package precourse.week3.controller;

import precourse.week3.domain.LottoResults;
import precourse.week3.domain.WinnerChecker;
import precourse.week3.domain.lottomaker.LottoMaker;
import precourse.week3.domain.lottomaker.LottoNumberGenerator;
import precourse.week3.domain.lottostore.LottoTicketsStore;
import precourse.week3.domain.lottoticket.LottoTickets;
import precourse.week3.domain.lottowinningnumber.LottoWinningNumbersMaker;
import precourse.week3.domain.money.Money;
import precourse.week3.view.InputView;
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
        outputView.printLottoTickets(lottoTickets);
        List<Integer> numbers = inputView.readWinningNumbers();
        int number = inputView.readBonusNumber();
        LottoWinningNumbersMaker lottoWinningNumbersMaker = new LottoWinningNumbersMaker();
        WinnerChecker winnerChecker = new WinnerChecker(lottoWinningNumbersMaker.createLottoWinningNumbers(numbers, number));
        LottoResults lottoResults = winnerChecker.check(lottoTickets);
        outputView.printStatistics(lottoResults.countByRank(), lottoResults.calculateRateOfReturn(LottoTicketsStore.LOTTO_PRICE));
    }
}
