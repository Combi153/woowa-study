package precourse.week3.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public int readPayment() {
        print(Message.PAY_GUIDE_MESSAGE);
        String input = readUsing(Validation.FOR_MONEY);
        return toInt(input);
    }

    public List<Integer> readWinningNumbers() {
        print(Message.WINNING_NUMBERS_GUIDE_MESSAGE);
        String input = readUsing(Validation.FOR_WINNING_NUMBERS);
        return toList(input);
    }

    public int readBonusNumber() {
        print(Message.BONUS_NUMBER_GUIDE_MESSAGE);
        String input = readUsing(Validation.FOR_BONUS_NUMBER);
        return toInt(input);
    }

    private void print(Message message) {
        OutputView outputView = new OutputView();
        outputView.print(message.getMessage());
    }

    private String readUsing(Validation validation) {
        String input = Console.readLine();
        validateBy(input, validation);
        return input;
    }

    private void validateBy(String input, Validation validation) {
        if (!input.matches(validation.getRegex())) {
            throw new IllegalArgumentException(validation.getErrorMessage());
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private List<Integer> toList(String input) {
        return Arrays.stream(input.split(WINNING_NUMBERS_DELIMITER))
                .map(this::toInt)
                .collect(Collectors.toList());
    }
}
