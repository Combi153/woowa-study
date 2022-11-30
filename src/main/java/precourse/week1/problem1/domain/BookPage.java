package precourse.week1.problem1.domain;

import java.util.ArrayList;
import java.util.List;

public class BookPage {

    private final int leftNumber;
    private final int rightNumber;

    public BookPage(List<Integer> numbers) {
        this(numbers.get(0), numbers.get(1));
    }

    public BookPage(int leftNumber, int rightNumber) {
        validate(leftNumber, rightNumber);
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    private void validate(int leftNumber, int rightNumber) {
        if (!isOdd(leftNumber) || isOdd(rightNumber)) {
            throw new IllegalArgumentException("[ERROR] 페이지가 형식에 맞지 않습니다.");
        }
        if (isOutOfRange(leftNumber) || isOutOfRange(rightNumber)) {
            throw new IllegalArgumentException("[ERROR] 페이지가 너무 큽니다.");
        }
        if (!isDifferenceOne(leftNumber, rightNumber)) {
            throw new IllegalArgumentException("[ERROR] 두 페이지의 차이가 1이 아닙니다.");
        }
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 400;
    }

    private boolean isDifferenceOne(int leftNumber, int rightNumber) {
        return rightNumber - leftNumber == 1;
    }

    public List<Integer> getLeftNumberDigit() {
        return makeDigits(leftNumber);
    }

    public List<Integer> getRightNumberDigit() {
        return makeDigits(rightNumber);
    }

    private List<Integer> makeDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }
}