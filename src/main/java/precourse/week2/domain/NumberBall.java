package precourse.week2.domain;

public class NumberBall {

    private final String number;

    public NumberBall(String number) {
        validate(number);
        this.number = number;
    }

    private void validate(String number) {
        if (!isThreeNumbers(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자 야구공은 세 개의 숫자로 구성되어야 합니다.");
        }
        if (hasDuplicate(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자 야구공은 서로 중복될 수 없습니다.");
        }
    }

    private boolean isThreeNumbers(String number) {
        return number.matches("\\d{3}");
    }

    private boolean hasDuplicate(String number) {
        return number.length() != number.chars()
                .distinct()
                .count();
    }
}
