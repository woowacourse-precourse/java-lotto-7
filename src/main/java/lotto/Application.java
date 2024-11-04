package lotto;

import com.sun.tools.javac.Main;
import lotto.controller.MainController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MainController mainController = new MainController(inputView, outputView);
        mainController.run();
    }
}
