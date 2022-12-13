package precourse.week4.domain;

import java.util.List;

public class GameResult {

    private final List<Trace> traces;
    private final boolean isSuccess;
    private final int numberOfAttempts;

    public GameResult(List<Trace> traces, boolean isSuccess, int numberOfAttempts) {
        this.traces = traces;
        this.isSuccess = isSuccess;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<Trace> getTraces() {
        return traces;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
