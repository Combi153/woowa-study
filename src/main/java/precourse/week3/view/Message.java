package precourse.week3.view;

public enum Message {

    PAY_GUIDE_MESSAGE("구입금액을 입력해 주세요.\n"),
    WINNING_NUMBERS_GUIDE_MESSAGE("당첨 번호를 입력해 주세요.\n"),
    BONUS_NUMBER_GUIDE_MESSAGE("보너스 번호를 입력해 주세요.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
