package precourse.week3.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readPayMoney() {
        print(Message.PAY_GUIDE_MESSAGE);
        return toInt(Console.readLine());
    }

    private int toInt(String input) {
        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String input) {
        if (!input.matches("\\d{1,}")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
        }
    }

    private void print(Message message) {
        System.out.print(message.getMessage());
    }
}
