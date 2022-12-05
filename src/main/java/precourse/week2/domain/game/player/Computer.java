package precourse.week2.domain.game.player;

import camp.nextstep.edu.missionutils.Randoms;
import precourse.week2.domain.game.ball.NumberBall;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANDOM_NUMBER_SIZE = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final String EMPTY_DELIMITER = "";

    public NumberBall createNumberBall() {
        return new NumberBall(makeRandomNumber());
    }

    private String makeRandomNumber() {
        List<String> numbers = new ArrayList<>();
        while (numbers.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addUnique(numbers, String.valueOf(randomNumber));
        }
        return String.join(EMPTY_DELIMITER, numbers);
    }

    private void addUnique(List<String> numbers, String randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
