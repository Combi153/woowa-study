package precourse.week2.domain.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

    @DisplayName("생성자에 1 혹은 2를 입력하였을 때, Command 객체가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void constructor_test(String commandNumber) {
        Command command = new Command(commandNumber);

        assertThat(command).isInstanceOf(Command.class);
    }

    @DisplayName("생성자에 1 혹은 2 외에 다른 문자를 입력하였을 때, Command 객체가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1 ", "22", "one", "two", "1empty", ""})
    void constructor_error_test(String commandNumber) {
        assertThatThrownBy(() -> new Command(commandNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}