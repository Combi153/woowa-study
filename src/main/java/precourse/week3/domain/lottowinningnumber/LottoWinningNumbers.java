package precourse.week3.domain.lottowinningnumber;

import precourse.week3.domain.LottoResult;
import precourse.week3.domain.winningnumber.LottoNumber;

import java.util.List;
import java.util.function.Predicate;

public class LottoWinningNumbers {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult grade(List<LottoNumber> numbers) {
        int numberOfMatching = countMatchingNumberWith(numbers);
        boolean hasBonusNumber = hasBonusNumber(numbers);
        return new LottoResult(numberOfMatching, hasBonusNumber);
    }

    private boolean hasBonusNumber(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
    }

    private int countMatchingNumberWith(List<LottoNumber> numbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> numbers.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .count();
    }
}
