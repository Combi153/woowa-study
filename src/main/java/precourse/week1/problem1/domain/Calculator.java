package precourse.week1.problem1.domain;

import java.util.List;

public class Calculator {

    public int calculateGameMaxNumber(BookPage bookPage) {
        int leftMax = calculateMaxOfSumAndMul(bookPage.getLeftNumberDigit());
        int rightMax = calculateMaxOfSumAndMul(bookPage.getRightNumberDigit());
        return Math.max(leftMax, rightMax);
    }

    private int calculateMaxOfSumAndMul(List<Integer> numbers) {
        int summation = sum(numbers);
        int multiplication = mul(numbers);
        return Math.max(summation, multiplication);
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int mul(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(1, (numberA, numberB) -> numberA * numberB);
    }
}
