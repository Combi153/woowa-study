package precourse.week2.domain.system;

public class Command {

    private static final String COMMAND_REGEX = "[12]";
    private static final String ERROR_MESSAGE = "[ERROR] 게임 커맨드는 1 혹은 2만 입력이 가능합니다.";
    private static final String START = "1";
    private final String command;

    public Command() {
        this(START);
    }

    public Command(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (isOneOrTwo(command)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean isOneOrTwo(String command) {
        return !command.matches(COMMAND_REGEX);
    }

    public boolean isStart() {
        return command.equals(START);
    }
}
