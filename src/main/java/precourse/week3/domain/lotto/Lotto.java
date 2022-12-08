package precourse.week3.domain.lotto;

import precourse.week3.domain.LottoResult;
import precourse.week3.domain.lottowinningnumber.LottoWinningNumbers;
import precourse.week3.domain.winningnumber.LottoNumber;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoResult compare(LottoWinningNumbers lottoWinningNumbers) {
        return lottoWinningNumbers.grade(numbers);
    }
}