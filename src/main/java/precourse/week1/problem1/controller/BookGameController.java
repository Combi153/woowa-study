package precourse.week1.problem1.controller;

import precourse.week1.problem1.domain.BookPage;
import precourse.week1.problem1.domain.Calculator;
import precourse.week1.problem1.domain.Referee;

import java.util.List;

public class BookGameController {

    public int runGameMain(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        try {
            return runBookGame(firstPlayer, secondPlayer);
        } catch (IllegalArgumentException e) {
            return Referee.EXCEPTION;
        }
    }

    private int runBookGame(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        BookPage firstPlayerPage = new BookPage(firstPlayer);
        BookPage secondPlayerPage = new BookPage(secondPlayer);

        int firstMax = calculateGameMaxNumberOf(firstPlayerPage);
        int secondMax = calculateGameMaxNumberOf(secondPlayerPage);
        return decideGameResultOf(firstMax, secondMax);
    }

    private int calculateGameMaxNumberOf(BookPage bookPage) {
        Calculator calculator = new Calculator();
        return calculator.calculateGameMaxNumber(bookPage);
    }

    private int decideGameResultOf(int firstPlayer, int secondPlayer) {
        Referee referee = new Referee();
        return referee.decideResultOfGame(firstPlayer, secondPlayer);
    }
}
