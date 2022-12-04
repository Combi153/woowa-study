package precourse.week1.problem4.domain;

public enum AsciiCode {

    START_OF_UPPER_CASE(65),
    END_OF_UPPER_CASE(90),
    START_OF_LOWER_CASE(97),
    END_OF_LOWER_CASE(122);

    private final int number;

    AsciiCode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
