package precourse.week2.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readNumberBall() {
        printNumberBallGuide();
        return Console.readLine();
    }

    private void printNumberBallGuide() {
        printGuide(Message.INPUT_NUMBER_BALL_GUIDE_MESSAGE);
    }

    public String readCommand() {
        printCommandGuide();
        return Console.readLine();
    }

    private void printCommandGuide() {
        printGuide(Message.INPUT_COMMAND_GUIDE_MESSAGE);
    }

    private void printGuide(Message message) {
        System.out.print(message.getMessage());
    }
}
