package precourse.week2.domain;

public class Referee {

    public Decision createDecision(NumberBall userBall, NumberBall computerBall) {
        int strike = makeStrikeDecision(userBall, computerBall);
        int ball = makeBallDecision(userBall, computerBall);
        return new Decision(strike, ball);
    }

    private int makeStrikeDecision(NumberBall userBall, NumberBall computerBall) {
        return computerBall.compareByIndex(userBall);
    }

    private int makeBallDecision(NumberBall userBall, NumberBall computerBall) {
        return computerBall.compareByValue(userBall) - computerBall.compareByIndex(userBall);
    }
}
