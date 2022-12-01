package precourse.week1.problem3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameNumber {

    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 10_000;
    private int number;

    public GameNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 게임 숫자는 1 이상 10,000 이하 자연수만 가능합니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < START_OF_RANGE || number > END_OF_RANGE;
    }

    public int count(int targetNumber) {
        List<Integer> digits = makeDigits(number);
        return (int) digits.stream()
                .filter(number -> number == targetNumber)
                .count();
    }

    private List<Integer> makeDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }

    public void update() {
        this.number++;
        validate(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameNumber that = (GameNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
