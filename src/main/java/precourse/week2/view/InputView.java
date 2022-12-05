package precourse.week2.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputNumberBall() {
        printNumberBallGuide();
        return Console.readLine();
    }

    private void printNumberBallGuide() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
