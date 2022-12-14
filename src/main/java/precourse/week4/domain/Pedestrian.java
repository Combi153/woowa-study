package precourse.week4.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedestrian {

    private static final String directionFormat = "[U,D]{1}";
    private static final String directionError = "[ERROR] 방향이 올바르지 않습니다.";
    private final Bridge bridge;
    private final List<Trace> traces;
    private int numberOfAttempts;

    public Pedestrian(Bridge bridge) {
        this.bridge = bridge;
        this.traces = new ArrayList<>();
        this.numberOfAttempts = 1;
    }

    public List<Trace> moveTo(String direction) {
        validate(direction);
        traces.add(new Trace(direction, bridge.judge(direction, traces.size())));
        return traces;
    }

    private void validate(String direction) {
        if (isInvalidFormat(direction)) {
            throw new IllegalArgumentException(directionError);
        }
    }

    private boolean isInvalidFormat(String direction) {
        return !direction.matches(directionFormat);
    }

    public void clearTraces() {
        traces.clear();
    }

    public void updateNumberOfAttempts() {
        ++numberOfAttempts;
    }

    public boolean isAtTheEndOfBridge() {
        return bridge.isEqualSize(traces.size()) && !hasIncorrectDirection();
    }

    public boolean isStopped() {
        return hasIncorrectDirection();
    }

    private boolean hasIncorrectDirection() {
        return traces.size() != traces.stream()
                .filter(Trace::isCorrectDirection)
                .count();
    }

    public GameResult createMovingResult() {
        return new GameResult(traces, isAtTheEndOfBridge(), numberOfAttempts);
    }

    public boolean isAtTheStartOfBridge() {
        return traces.size() == 0;
    }
}
