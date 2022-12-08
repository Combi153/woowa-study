package precourse.week3.domain.lottomaker;

import precourse.week3.domain.lotto.Lotto;
import precourse.week3.domain.winningnumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMaker {

    private final RandomNumberGenerator generator;

    public LottoMaker(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public Lotto createLotto() {
        return new Lotto(makeLotto());
    }

    private List<LottoNumber> makeLotto() {
        return makeLottoNumbers(makeRandomNumbers());
    }

    private List<LottoNumber> makeLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<Integer> makeRandomNumbers() {
        return generator.generate();
    }
}
