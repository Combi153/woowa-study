package precourse.week3.domain.lottomaker;

import precourse.week3.domain.lotto.Lotto;

import java.util.List;

public class LottoMaker {

    private final RandomNumberGenerator generator;

    public LottoMaker(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public Lotto createLotto() {
        return new Lotto(makeLotto());
    }

    private List<Integer> makeLotto() {
        return makeRandomNumbers();
    }

    private List<Integer> makeRandomNumbers() {
        return generator.generate();
    }
}
