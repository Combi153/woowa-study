package precourse.week1.problem3.controller;

import precourse.week1.problem3.domain.GameNumber;
import precourse.week1.problem3.domain.GameOf369;

public class GameOf369Controller {

    public int run369GameUntil(int number) {
        GameOf369 game = createBasicGame();
        return game.runGame369Until(new GameNumber(number));
    }

    private GameOf369 createBasicGame() {
        GameNumber startNumber = new GameNumber(GameOf369.BASIC_START);
        return new GameOf369(startNumber);
    }
}
