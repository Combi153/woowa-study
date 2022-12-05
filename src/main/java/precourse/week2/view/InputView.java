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


    public String inputCommand() {
        printCommandGuide();
        return Console.readLine();
    }

    private void printCommandGuide() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }
}
