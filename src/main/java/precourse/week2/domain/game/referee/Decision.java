package precourse.week2.domain.game.referee;

public class Decision {

    private static final int NOTHING = 0;
    private static final int FULL_STRIKE = 3;
    private final int strike;
    private final int ball;

    public Decision(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isFullStrike() {
        return strike == FULL_STRIKE;
    }

    public boolean hasBall() {
        return ball != NOTHING;
    }

    public boolean hasStrike() {
        return strike != NOTHING;
    }

    public boolean hasNothing() {
        return ball == NOTHING && strike == NOTHING;
    }
}
