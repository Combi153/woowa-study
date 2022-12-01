package precourse.week1.problem3;

import precourse.week1.problem3.controller.GameOf369Controller;

public class Problem3 {

    public static int solution(int number) {
        GameOf369Controller controller = new GameOf369Controller();
        return controller.run369GameUntil(number);
    }
}
