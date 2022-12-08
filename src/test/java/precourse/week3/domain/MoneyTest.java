package precourse.week3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import precourse.week3.domain.money.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("생성자 메소드에 1000 이상의 1000의 배수인 int 수를 입력하였을 때, Money 객체가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 100_000_000})
    void constructor_test(int testMoney) {
        Money money = new Money(testMoney);

        assertThat(money).isInstanceOf(Money.class);
    }

    @DisplayName("생성자 메소드에 1000 이하거나 1000의 배수가 아닌 int 수를 입력하였을 때, 오류가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {100, 500, 2001, 10002, 100_000_020})
    void constructor_error_test(int testMoney) {
        assertThatThrownBy(() -> new Money(testMoney)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}