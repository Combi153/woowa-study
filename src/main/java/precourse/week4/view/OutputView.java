package precourse.week4.view;

import precourse.week4.domain.GameResult;
import precourse.week4.domain.Trace;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        print(Message.START.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Trace> traces) {
        print(makeBridgeMap(traces));
    }

    private String makeBridgeMap(List<Trace> traces) {
        List<String> upperDirections = new ArrayList<>();
        List<String> lowerDirections = new ArrayList<>();
        for (Trace trace : traces) {
            makeDirections(upperDirections, lowerDirections, trace);
        }
        return makeBridgeMessage(upperDirections) + makeBridgeMessage(lowerDirections);
    }

    private String makeBridgeMessage(List<String> directions) {
        String bridgeContent = String.join(Message.BRIDGE_DELIMITER.getMessage(), directions);
        return format(Message.BRIDGE_EDGE, bridgeContent);
    }

    private void makeDirections(List<String> upperDirections, List<String> lowerDirections, Trace trace) {
        if (trace.isUpwardDirection()) {
            addByTrace(upperDirections, lowerDirections, trace);
        }
        if (trace.isDownwardDirection()) {
            addByTrace(lowerDirections, upperDirections, trace);
        }
    }

    private void addByTrace(List<String> firstDirections, List<String> secondDirections, Trace trace) {
        firstDirections.add(getDirectionMessage(trace));
        secondDirections.add(Message.NOTHING.getMessage());
    }

    private String getDirectionMessage(Trace trace) {
        if (trace.isCorrectDirection()) {
            return Message.CORRECT_DIRECTION.getMessage();
        }
        return Message.INCORRECT_DIRECTION.getMessage();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult result) {
        print(Message.GAME_RESULT.getMessage());
        printMap(result.getTraces());
        print(format(Message.SUCCESS_RESULT, makeSuccessMessage(result)));
        print(format(Message.NUMBER_OF_ATTEMPTS, result.getNumberOfAttempts()));
    }

    private String makeSuccessMessage(GameResult result) {
        if (result.isSuccess()) {
            return Message.SUCCESS.getMessage();
        }
        return Message.FAIL.getMessage();
    }

    private static String format(Message message, Object factor) {
        return String.format(message.getMessage(), factor);
    }

    public void printErrorMessage(String message) {
        print(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
