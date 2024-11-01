package lotto;

import lotto.controller.GameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        GameController controller = new GameController(inputView, outputView, numbersGenerator);
        controller.run();
    }
}
