package precourse.week3.domain;

import precourse.week3.domain.lottoticket.LottoTickets;
import precourse.week3.domain.lottowinningnumber.LottoWinningNumbers;

import java.util.List;

public class WinnerChecker {

    private final LottoWinningNumbers lottoWinningNumbers;

    public WinnerChecker(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public LottoResults check(LottoTickets lottoTickets) {
        return new LottoResults(makeLottoResults(lottoTickets));
    }

    private List<LottoResult> makeLottoResults(LottoTickets lottoTickets) {
        return lottoTickets.compareWith(lottoWinningNumbers);
    }
}