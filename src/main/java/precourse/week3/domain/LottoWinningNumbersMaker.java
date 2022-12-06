package precourse.week3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumbersMaker {

    public LottoWinningNumbers createLottoWinningNumbers(List<Integer> numbers, int number) {
        validateDuplication(numbers, number);
        return new LottoWinningNumbers(makeWinningNumbers(numbers), makeWinningNumber(number));
    }

    private List<WinningNumber> makeWinningNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toList());
    }

    private WinningNumber makeWinningNumber(int number) {
        return new WinningNumber(number);
    }

    private void validateDuplication(List<Integer> numbers, int number) {
        if (hasDuplication(numbers, number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplication(List<Integer> numbers, int number) {
        return numbers.size() != countUniqueValue(numbers) || numbers.contains(number);
    }

    private long countUniqueValue(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }
}
