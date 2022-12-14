package precourse.week2.domain.game.ball;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberBall {

    private static final String FORM_ERROR_MESSAGE = "[ERROR] 숫자 야구공은 세 개의 숫자로 구성되어야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 숫자 야구공은 서로 중복될 수 없습니다.";
    private static final String NUMBER_BALL_REGEX = "[1-9]{3}";
    private final String number;

    public NumberBall(String number) {
        validate(number);
        this.number = number;
    }

    private void validate(String number) {
        if (!isThreeNumbers(number)) {
            throw new IllegalArgumentException(FORM_ERROR_MESSAGE);
        }
        if (hasDuplicate(number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private boolean isThreeNumbers(String number) {
        return number.matches(NUMBER_BALL_REGEX);
    }

    private boolean hasDuplicate(String number) {
        return number.length() != number.chars()
                .distinct()
                .count();
    }

    public int compareByIndex(NumberBall otherBall) {
        List<String> otherNumbers = makeNumbers(otherBall.number);
        List<String> numbers = makeNumbers(this.number);
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            String numberBall = numbers.get(i);
            String otherNumberBall = otherNumbers.get(i);
            count = updateBy(count, numberBall, otherNumberBall);
        }
        return count;
    }

    private int updateBy(int count, String numberBall, String otherNumberBall) {
        if (numberBall.equals(otherNumberBall)) {
            count++;
        }
        return count;
    }

    public int compareByValue(NumberBall otherBall) {
        List<String> otherNumbers = makeNumbers(otherBall.number);
        List<String> numbers = makeNumbers(this.number);
        return (int) numbers.stream()
                .filter(number -> otherNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private List<String> makeNumbers(String numberBall) {
        return numberBall.chars()
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }
}
