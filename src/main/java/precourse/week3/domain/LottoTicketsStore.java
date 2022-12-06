package precourse.week3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsStore {

    public static final int LOTTO_PRICE = 1000;
    private final LottoFactory lottoFactory;

    public LottoTicketsStore(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public LottoTickets sellLottoTickets(Money money) {
        int count = divideByPrice(money);
        return createLottoTickets(count);
    }

    private LottoTickets createLottoTickets(int count) {
        return new LottoTickets(makeLottoTickets(count));
    }

    private int divideByPrice(Money money) {
        return money.pay(LOTTO_PRICE);
    }

    private List<Lotto> makeLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(lottoFactory.createLotto());
        }
        return lottoTickets;
    }
}
