package precourse.week2.view;

public enum Message {

    START_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    NOTHING_DECISION_MESSAGE("낫싱"),
    BALL_DECISION_MESSAGE("%d볼"),
    STRIKE_DECISION_MESSAGE("%d스트라이크"),
    DECISION_DELIMITER(" "),
    NEW_LINE("\n"),
    ANSWER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    INPUT_NUMBER_BALL_GUIDE_MESSAGE("숫자를 입력해주세요 : "),
    INPUT_COMMAND_GUIDE_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object value) {
        return String.format(message, value);
    }
}
