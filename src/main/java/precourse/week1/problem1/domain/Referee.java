package precourse.week1.problem1.domain;

public class Referee {

    private static final int VICTORY_OF_FIRST_PLAYER = 1;
    private static final int VICTORY_OF_SECOND_PLAYER = 2;
    private static final int DRAW = 0;
    public static final int EXCEPTION = -1;

    public int decideResultOfGame(int firstPlayerMax, int secondPlayerMax) {
        if (firstPlayerMax > secondPlayerMax) {
            return VICTORY_OF_FIRST_PLAYER;
        }
        if (firstPlayerMax < secondPlayerMax) {
            return VICTORY_OF_SECOND_PLAYER;
        }
        return DRAW;
    }
}
