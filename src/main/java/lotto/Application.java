package lotto;

import lotto.controller.GameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController controller = new GameController(inputView, outputView);
        controller.run();
    }
}
