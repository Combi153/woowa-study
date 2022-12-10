package precourse.week3.view;

public enum Message {

    PAY_GUIDE_MESSAGE("구입금액을 입력해 주세요.\n"),
    PAYMENT_MESSAGE("%d개를 구매했습니다.\n"),
    LOTTO_DELIMITER(", "),
    LOTTO_PREFIX("["),
    LOTTO_SUFFIX("]\n"),
    WINNING_NUMBERS_GUIDE_MESSAGE("당첨 번호를 입력해 주세요.\n"),
    BONUS_NUMBER_GUIDE_MESSAGE("보너스 번호를 입력해 주세요.\n"),
    STATISTICS_TITLE_MESSAGE("당첨 통계\n---\n"),
    STATISTICS_NORMAL_CONTENT_MESSAGE("%d개 일치 (%s원) - %d개\n"),
    STATISTICS_BONUS_CONTENT_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    RATE_OF_RETURN_MESSAGE("총 수익률은 %s%%입니다.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
