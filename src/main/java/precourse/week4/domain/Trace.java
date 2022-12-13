package precourse.week4.domain;

import precourse.week4.BridgeMaker;

public class Trace {

    private final String userDirection;
    private final boolean isCorrectDirection;

    public Trace(String userDirection, boolean isCorrectDirection) {
        this.userDirection = userDirection;
        this.isCorrectDirection = isCorrectDirection;
    }

    public boolean isUpwardDirection() {
        return userDirection.equals(BridgeMaker.UPWARD_DIRECTION);
    }

    public boolean isDownwardDirection() {
        return userDirection.equals(BridgeMaker.DOWNWARD_DIRECTION);
    }

    public boolean isCorrectDirection() {
        return isCorrectDirection;
    }
}
