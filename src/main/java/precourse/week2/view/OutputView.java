package precourse.week2.view;

import precourse.week2.domain.Decision;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public void printStartMessage() {
        System.out.print("숫자 야구 게임을 시작합니다.\n");
    }

    public void printDecisionMessage(Decision decision) {
        List<String> messages = new ArrayList<>();
        if (decision.hasBall()) {
            messages.add(String.format("%s볼", decision.getBall()));
        }
        if (decision.hasStrike()) {
            messages.add(String.format("%s스트라이크", decision.getStrike()));
        }
        if (decision.hasNothing()) {
            messages.add("낫싱");
        }
        System.out.print(String.join(" ", messages) + "\n");
    }

    public void printAnswerMessage() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.print(errorMessage);
    }
}
