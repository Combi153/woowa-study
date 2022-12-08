package precourse.week3.domain.lottoticket;

import precourse.week3.domain.LottoResult;
import precourse.week3.domain.lotto.Lotto;
import precourse.week3.domain.lottowinningnumber.LottoWinningNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoResult> compareWith(LottoWinningNumbers lottoWinningNumbers) {
        return lottoTickets.stream()
                .map(lotto -> lotto.compare(lottoWinningNumbers))
                .collect(Collectors.toList());
    }
}
