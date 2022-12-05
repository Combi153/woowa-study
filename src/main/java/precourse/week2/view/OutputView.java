package precourse.week2.view;

import precourse.week2.domain.game.referee.Decision;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public void printStartMessage() {
        print(Message.START_MESSAGE);
    }

    public void printDecisionMessage(Decision decision) {
        String message = makeDecisionMessage(decision);
        print(message + Message.NEW_LINE.getMessage());
    }

    private String makeDecisionMessage(Decision decision) {
        List<String> decisions = new ArrayList<>();
        if (decision.hasNothing()) {
            decisions.add(Message.NOTHING_DECISION_MESSAGE.getMessage());
            return makeMessageBy(decisions);
        }
        if (decision.hasBall()) {
            decisions.add(Message.BALL_DECISION_MESSAGE.getFormattedMessage(decision.getBall()));
        }
        if (decision.hasStrike()) {
            decisions.add(Message.STRIKE_DECISION_MESSAGE.getFormattedMessage(decision.getStrike()));
        }
        return makeMessageBy(decisions);
    }

    private String makeMessageBy(List<String> decisions) {
        return String.join(Message.DECISION_DELIMITER.getMessage(), decisions);
    }

    public void printAnswerMessage() {
        print(Message.ANSWER_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        print(Message.NEW_LINE.getMessage() + errorMessage);
    }

    private void print(Message message) {
        System.out.print(message.getMessage());
    }

    private void print(String message) {
        System.out.print(message);
    }
}
