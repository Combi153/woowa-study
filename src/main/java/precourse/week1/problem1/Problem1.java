package precourse.week1.problem1;

import precourse.week1.problem1.controller.BookGameController;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        BookGameController bookGameController = new BookGameController();
        return bookGameController.runGameMain(pobi, crong);
    }
}