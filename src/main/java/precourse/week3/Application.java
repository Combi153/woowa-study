package precourse.week3;

import precourse.week3.controller.LottoController;
import precourse.week3.view.InputView;
import precourse.week3.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView());
        lottoController.runLottoProgramMain();
    }
}
