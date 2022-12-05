package precourse.week2;

import precourse.week2.controller.NumberBaseballController;
import precourse.week2.view.InputView;
import precourse.week2.view.OutputView;

public class Application {
    public static void main(String[] args) {
        NumberBaseballController controller = new NumberBaseballController(new InputView(), new OutputView());
        controller.runMainSystem();
    }
}
