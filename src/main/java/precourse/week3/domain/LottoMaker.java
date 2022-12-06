package precourse.week3.domain;

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
        return generator.generate();
    }
}
