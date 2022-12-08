package precourse.week3.domain.money;

import precourse.week3.domain.lottostore.LottoTicketsStore;

public class Money {

    private static final int NONE_VALUE = 0;
    private final int money;

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
        return money < LottoTicketsStore.LOTTO_PRICE;
    }

    private boolean isMultipleOfPrice(int money) {
        return money % LottoTicketsStore.LOTTO_PRICE == NONE_VALUE;
    }

    public int pay(int price) {
        validatePay(price);
        return this.money / price;
    }

    private void validatePay(int price) {
        if (price == NONE_VALUE) {
            throw new ArithmeticException("[ERROR] 가격이 0이 될 수 없습니다.");
        }
    }
}
