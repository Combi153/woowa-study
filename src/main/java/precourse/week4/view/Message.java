package precourse.week4.view;

public enum Message {

    START("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_INPUT_GUIDE("다리의 길이를 입력해주세요.\n"),
    MOVE_GUIDE("이동할 칸을 선택해주세요. (위: U, 아래: D)\n"),
    RETRY_GUIDE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"),
    GAME_RESULT("최종 게임 결과\n"),
    SUCCESS_RESULT("게임 성공 여부: %s"),
    NUMBER_OF_ATTEMPTS("총 시도한 횟수: %d"),
    SUCCESS("성공\n"),
    FAIL("실패\n"),
    CORRECT_DIRECTION("O"),
    INCORRECT_DIRECTION("X"),
    NOTHING(" "),
    BRIDGE_EDGE("[ %s ]\n"),
    BRIDGE_DELIMITER(" | ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSuccessMessage(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS.getMessage();
        }
        return FAIL.getMessage();
    }
}
