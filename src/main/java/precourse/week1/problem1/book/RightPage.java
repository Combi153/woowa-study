package precourse.week1.problem1.book;

public class RightPage {

    private final int number;

    public RightPage(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isEven(number)) {
            throw new IllegalArgumentException("[ERROR] 오른쪽 페이지는 짝수여야 합니다.");
        }
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 책 페이지를 넘어선 입력입니다.");
        }
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 400;
    }
}
