package precourse.week1.problem1.book;

public class LeftPage {

    private final int number;

    public LeftPage(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOdd(number)) {
            throw new IllegalArgumentException("[ERROR] 왼쪽 페이지는 홀수여야 합니다.");
        }
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 책 페이지를 넘어선 입력입니다.");
        }
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }


    private boolean isOutOfRange(int number) {
        return number < 1 || number > 400;
    }
}
