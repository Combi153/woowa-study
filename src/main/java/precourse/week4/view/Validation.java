package precourse.week4.view;

public enum Validation {

    BRIDGE_SIZE_FORM("\\d{1,2}", "[ERROR] 다리 길이 입력 형식에 맞지 않습니다.");

    private final String form;
    private final String errorMessage;

    Validation(String form, String errorMessage) {
        this.form = form;
        this.errorMessage = errorMessage;
    }

    public boolean isValidFormat(String input) {
        return input.matches(form);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
