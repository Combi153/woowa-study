package precourse.week3.domain;

import java.util.List;

public class LottoFactory {

    private final RandomNumberGenerator generator;

    public LottoFactory(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public Lotto createLotto() {
        return new Lotto(makeLotto());
    }

    private List<Integer> makeLotto() {
        return generator.generate();
    }
}
