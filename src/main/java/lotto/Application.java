package lotto;

import lotto.Controller.MainController;
import lotto.View.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        MainController mainController = new MainController(
                new InputView()
        );
        mainController.run();
    }
}
