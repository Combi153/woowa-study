package precourse.week3.domain.lottowinningnumber;

import precourse.week3.domain.LottoResult;
import precourse.week3.domain.winningnumber.LottoNumber;

import java.util.List;

public class LottoWinningNumbers {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult grade(List<Integer> numbers) {
        int numberOfMatching = countMatchingNumberWith(numbers);
        boolean hasBonusNumber = hasBonusNumber(numbers);
        return new LottoResult(numberOfMatching, hasBonusNumber);
    }

    private boolean hasBonusNumber(List<Integer> numbers) {
        return bonusNumber.isContained(numbers);
    }

    private int countMatchingNumberWith(List<Integer> numbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> numbers.stream()
                        .anyMatch(lottoNumber::isEqualValue))
                .count();
    }
}
