package precourse.week4.controller;

import precourse.week4.BridgeMaker;
import precourse.week4.BridgeRandomNumberGenerator;
import precourse.week4.domain.Bridge;
import precourse.week4.domain.BridgeGame;
import precourse.week4.domain.Pedestrian;
import precourse.week4.domain.Trace;
import precourse.week4.view.InputView;
import precourse.week4.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runBridgeGameMain() {
        outputView.printStartMessage();
        Bridge bridge = createBridge();
        Pedestrian pedestrian = new Pedestrian(bridge);
        BridgeGame bridgeGame = new BridgeGame(pedestrian);

        while (bridgeGame.isPlaying() && !bridgeGame.isCompleted()) {
            outputView.printMap(executeMove(bridgeGame));
            if (bridgeGame.isOver()) {
                executeRetry(bridgeGame);
            }
        }
        outputView.printResult(bridgeGame.getGameResult());
    }

    private Bridge createBridge() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                List<String> bridgeDirections = bridgeMaker.makeBridge(bridgeSize);
                return new Bridge(bridgeDirections);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Trace> executeMove(BridgeGame bridgeGame) {
        while (true) {
            try {
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void executeRetry(BridgeGame bridgeGame) {
        boolean isInvalidInput = true;
        while (isInvalidInput) {
            try {
                bridgeGame.retry(inputView.readGameCommand());
                isInvalidInput = false;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
