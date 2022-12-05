package precourse.week2.domain.game.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import precourse.week2.domain.game.ball.NumberBall;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        this.computer = new Computer();
    }

    @DisplayName("createNumberBall 메소드를 실행하였을 때, NumberBall 객체를 반환하는지 확인")
    @Test
    void createNumberBall_test() {
        NumberBall computerBall = computer.createNumberBall();

        assertThat(computerBall).isInstanceOf(NumberBall.class);
    }

    @DisplayName("createNumberBall 메소드를 두 번 실행하였을 때, 서로 다른 NumberBall 객체를 반환하는지 확인")
    @Test
    void createNumberBall_twice_test() {
        NumberBall firstBall = computer.createNumberBall();
        NumberBall secondBall = computer.createNumberBall();

        assertThat(firstBall.equals(secondBall)).isFalse();
    }
}