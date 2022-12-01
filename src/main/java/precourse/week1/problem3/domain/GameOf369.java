package precourse.week1.problem3.domain;

import java.util.List;

public class GameOf369 {

    private static final List<Integer> TARGET_NUMBERS = List.of(3, 6, 9);
    public static final int BASIC_START = 1;
    private final GameNumber playingNumber;

    public GameOf369(GameNumber startNumber) {
        this.playingNumber = startNumber;
    }

    public int runGame369Until(GameNumber endNumber) {
        int count = 0;
        while (!playingNumber.equals(endNumber)) {
            count += countTargetNumber(playingNumber);
            playingNumber.update();
        }
        count += countTargetNumber(playingNumber);
        return count;
    }

    private int countTargetNumber(GameNumber number) {
        int count = 0;
        for (Integer targetNumber : TARGET_NUMBERS) {
            count += number.count(targetNumber);
        }
        return count;
    }
}
