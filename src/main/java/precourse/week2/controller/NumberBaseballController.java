package precourse.week2.controller;

import precourse.week2.domain.system.Command;
import precourse.week2.domain.game.player.Computer;
import precourse.week2.domain.game.referee.Decision;
import precourse.week2.domain.game.ball.NumberBall;
import precourse.week2.domain.game.referee.Referee;
import precourse.week2.view.InputView;
import precourse.week2.view.OutputView;

public class NumberBaseballController {

    private final InputView inputView;
    private final OutputView outputView;

    public NumberBaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runMainSystem() {
        try {
            runGameSystem();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }

    private void runGameSystem() {
        outputView.printStartMessage();
        Command command = new Command();
        Computer computer = new Computer();

        while (command.isStart()) {
            NumberBall computerBall = computer.createNumberBall();
            runNumberBaseballGame(computerBall);
            outputView.printAnswerMessage();
            command = receiveCommand();
        }
    }

    private void runNumberBaseballGame(NumberBall computerBall) {
        Decision decision;
        do {
            NumberBall userBall = receiveUserBall();
            decision = receiveDecision(computerBall, userBall);
            outputView.printDecisionMessage(decision);
        } while (!decision.isFullStrike());
    }

    private Decision receiveDecision(NumberBall computerBall, NumberBall userBall) {
        Referee referee = new Referee();
        return referee.createDecision(userBall, computerBall);
    }

    private NumberBall receiveUserBall() {
        return new NumberBall(inputView.readNumberBall());
    }

    private Command receiveCommand() {
        return new Command(inputView.readCommand());
    }
}
