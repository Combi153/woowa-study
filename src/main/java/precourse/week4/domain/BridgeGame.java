package precourse.week4.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RESTART_COMMAND = "R";
    private final Pedestrian pedestrian;

    public BridgeGame(Pedestrian pedestrian) {
        this.pedestrian = pedestrian;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<Trace> move(String direction) {
        return pedestrian.moveTo(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        validate(command);
        if (command.equals(RESTART_COMMAND)) {
            pedestrian.clearTraces();
            pedestrian.updateNumberOfAttempts();
        }
    }

    private void validate(String command) {
        if (!command.matches("[R,Q]")) {
            throw new IllegalArgumentException("[ERROR] 명령어는 R 혹은 Q여야 합니다.");
        }
    }

    public boolean isCompleted() {
        return pedestrian.isAtTheEndOfBridge();
    }

    public boolean isPlaying() {
        return pedestrian.isAtTheStartOfBridge() || !pedestrian.isStopped();
    }

    public boolean isOver() {
        return pedestrian.isStopped();
    }

    public GameResult getGameResult() {
        return pedestrian.createMovingResult();
    }
}
