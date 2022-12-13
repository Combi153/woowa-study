package precourse.week4.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        print(Message.BRIDGE_SIZE_INPUT_GUIDE.getMessage());
        String input = readUsing(Validation.BRIDGE_SIZE_FORM);
        return toInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        print(Message.MOVE_GUIDE.getMessage());
        return readUsing(Validation.MOVING_COMMAND_FORM);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String readUsing(Validation validation) {
        while (true) {
            try {
                String input = Console.readLine();
                validateBy(input, validation);
                return input;
            } catch (IllegalArgumentException e) {
                print(e.getMessage());
            }
        }
    }

    private void validateBy(String input, Validation validation) {
        if (validation.isInvalidFormat(input)) {
            throw new IllegalArgumentException(validation.getErrorMessage());
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
