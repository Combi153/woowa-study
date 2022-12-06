package precourse.week3.domain;

public class Money {

    private final int money;
    private static final int NONE_REMAINDER = 0;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (isLessThanPrice(money)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상부터 가능합니다.");
        }
        if (!isMultipleOfPrice(money)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    private boolean isLessThanPrice(int money) {
        return money < 1000;
    }

    private boolean isMultipleOfPrice(int money) {
        return money % 1000 == NONE_REMAINDER;
    }
}
