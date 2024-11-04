package lotto;

import lotto.controller.LottosController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.UserInput;
import lotto.view.UserOutput;

public class Application {
    public static void main(String[] args) {
        UserOutput outputView = new OutputView();
        UserInput inputView = new InputView();
        LottosController lottosController = new LottosController(inputView, outputView);
        lottosController.buy();
    }
}
