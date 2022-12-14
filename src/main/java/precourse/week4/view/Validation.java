package precourse.week4.view;

public enum Validation {

    BRIDGE_SIZE_FORM("\\d{1,2}", "[ERROR] 다리 길이 입력 형식에 맞지 않습니다."),
    MOVING_COMMAND_FORM("\\D{1}", "[ERROR] 방향은 문자 하나로 입력해야 합니다."),
    PLAYING_COMMAND_FORM("\\D{1}", "[ERROR] 명령어는 문자 하나로 입력해야 합니다.");

    private final String form;
    private final String errorMessage;

    Validation(String form, String errorMessage) {
        this.form = form;
        this.errorMessage = errorMessage;
    }

    public boolean isInvalidFormat(String input) {
        return !input.matches(form);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
