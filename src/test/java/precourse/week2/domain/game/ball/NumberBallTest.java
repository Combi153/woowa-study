package precourse.week2.domain.game.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberBallTest {

    @DisplayName("생성자에 1부터 9 숫자 중 세 가지를 중복없이 입력하였을 때 NumberBall 객체가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "345", "198", "975"})
    void constructor_test(String number) {
        NumberBall numberBall = new NumberBall(number);

        assertThat(numberBall).isInstanceOf(NumberBall.class);
    }

    @DisplayName("생성자에 범위를 벗어나거나, 중복이 있거나 혹은 세 자리가 아닌 숫자를 입력하였을 때 오류가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"120", "111", "12", "1 3", "1234", "981 "})
    void constructor_error_test(String errorNumber) {
        assertThatThrownBy(() -> new NumberBall(errorNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("compareByIndex 메소드에 NumberBall 객체를 입력하였을 때 위치를 기준으로 각 멤버변수를 비교한 결과를 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"123, 123, 3", "123, 124, 2", "123, 132, 1", "123, 312, 0"})
    void compareByIndex_test(String number, String otherNumber, int expectedValue) {
        NumberBall numberBall = new NumberBall(number);
        NumberBall otherNumberBall = new NumberBall(otherNumber);

        int actualCount = numberBall.compareByIndex(otherNumberBall);

        assertThat(actualCount).isEqualTo(expectedValue);
    }

    @DisplayName("compareByValue 메소드에 NumberBall 객체를 입력하였을 때 값을 기준으로 각 멤버변수를 비교한 결과를 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"123, 123, 3", "123, 124, 2", "123, 451, 1", "123, 132, 3", "123, 456, 0"})
    void compareByValue_test(String number, String otherNumber, int expectedValue) {
        NumberBall numberBall = new NumberBall(number);
        NumberBall otherNumberBall = new NumberBall(otherNumber);

        int actualCount = numberBall.compareByValue(otherNumberBall);

        assertThat(actualCount).isEqualTo(expectedValue);
    }
}