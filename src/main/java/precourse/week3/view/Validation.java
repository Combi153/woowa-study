package precourse.week3.view;

public enum Validation {
    FOR_MONEY("\\d{1,9}", "[ERROR] 구입금액은 1자리 이상 9자리 이하 숫자로 입력해야 합니다."),
    FOR_WINNING_NUMBERS("\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}", "[ERROR] 당첨 번호 입력 형식이 맞지 않습니다."),
    FOR_BONUS_NUMBER("\\d{1,2}", "[ERROR] 보너스 번호 입력 형식이 맞지 않습니다.");

    private final String regex;
    private final String errorMessage;

    Validation(String regex, String errorMessage) {
        this.regex = regex;
        this.errorMessage = errorMessage;
    }

    public String getRegex() {
        return regex;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
