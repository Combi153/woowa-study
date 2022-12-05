package precourse.week2.domain;

public class Command {

    private final String command;

    public Command(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (!command.matches("[12]")) {
            throw new IllegalArgumentException("[ERROR] 게임 커맨드는 1 혹은 2만 입력이 가능합니다.");
        }
    }
}
