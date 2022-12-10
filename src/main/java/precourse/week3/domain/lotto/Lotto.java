package precourse.week3.domain.lotto;

import precourse.week3.domain.lottowinningnumber.LottoWinningNumbers;
import precourse.week3.domain.result.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isOutOfSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private boolean isOutOfSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.size() != countUniqueValue(numbers);
    }

    private long countUniqueValue(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    public LottoResult compare(LottoWinningNumbers lottoWinningNumbers) {
        return lottoWinningNumbers.grade(numbers);
    }

    public String toMessage(String delimiter, String prefix, String suffix) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}