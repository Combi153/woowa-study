package precourse.week2.domain.game.referee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import precourse.week2.domain.game.ball.NumberBall;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        this.referee = new Referee();
    }

    @DisplayName("createDecision 메소드에 NumberBall 객체를 두 개 입력하였을 때, 스트라이크와 볼의 개수를 담은 Decision 객체를 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"123, 123, 3, 0", "123, 124, 2, 0", "123, 321, 1, 2", "123, 456, 0, 0"})
    void createDecision_test(String number, String anotherNumber, int expectedStrike, int expectedBall) {
        Decision decision = referee.createDecision(new NumberBall(number), new NumberBall(anotherNumber));

        int actualStrike = decision.getStrike();
        int actualBall = decision.getBall();

        assertThat(actualStrike == expectedStrike && actualBall == expectedBall).isTrue();
    }
}