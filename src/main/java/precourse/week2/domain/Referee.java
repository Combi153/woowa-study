package precourse.week2.domain;

import java.util.HashMap;
import java.util.Map;

public class Referee {

    private final NumberBall computerBall;

    public Referee(NumberBall computerBall) {
        this.computerBall = computerBall;
    }

    public Decision createDecision(NumberBall userBall) {
        int strike = makeStrikeDecision(userBall);
        int ball = makeBallDecision(userBall);
        return new Decision(strike, ball);
    }

    private int makeStrikeDecision(NumberBall userBall) {
        return computerBall.compareByIndex(userBall);
    }

    private int makeBallDecision(NumberBall userBall) {
        return computerBall.compareByValue(userBall) - computerBall.compareByIndex(userBall);
    }
}
