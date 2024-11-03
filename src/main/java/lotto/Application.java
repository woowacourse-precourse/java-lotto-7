package lotto;

import lotto.Controller.MainController;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MainController controller = new MainController(inputView, outputView);
        controller.run();
    }
}