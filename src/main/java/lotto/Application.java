package lotto;

import lotto.controller.Controller;
import lotto.view.InputHandler;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        InputView inputView = new InputView(inputHandler);

        Controller controller = new Controller(inputHandler, inputView);

        controller.run();
    }
}
