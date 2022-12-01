package precourse.week1.problem3.domain;

public class GameNumber {

    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 10_000;
    private int number;

    public GameNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if(isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 게임 숫자는 1 이상 10,000 이하 자연수만 가능합니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < START_OF_RANGE || number > END_OF_RANGE;
    }
}
