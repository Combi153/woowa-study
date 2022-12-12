package precourse.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int START_OF_BRIDGE_RANGE = 3;
    private static final int END_OF_BRIDGE_RANGE = 20;
    private static final int UPWARD_NUMBER = 1;
    public static final String UPWARD_DIRECTION = "U";
    public static final String DOWNWARD_DIRECTION = "D";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);
        return combineBridgeFactor(size);
    }

    private List<String> combineBridgeFactor(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(makeBridgeFactor());
        }
        return bridge;
    }

    private String makeBridgeFactor() {
        int number = bridgeNumberGenerator.generate();
        if (number == UPWARD_NUMBER) {
            return UPWARD_DIRECTION;
        }
        return DOWNWARD_DIRECTION;
    }

    private void validate(int size) {
        if (isOutOfRange(size)) {
            throw new IllegalArgumentException("[ERROR] 입력된 다리 길이가 범위를 벗어났습니다.");
        }
    }

    private boolean isOutOfRange(int size) {
        return size < START_OF_BRIDGE_RANGE || size > END_OF_BRIDGE_RANGE;
    }
}