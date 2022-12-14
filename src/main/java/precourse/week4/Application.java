package precourse.week4;

import precourse.week4.controller.BridgeGameController;
import precourse.week4.view.InputView;
import precourse.week4.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController(new InputView(), new OutputView());
        controller.runBridgeGameMain();
    }
}