package lotto;

import lotto.controller.Controller;
import lotto.utils.Utils;
import lotto.validator.Validators;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller lotto = new Controller(new InputView(), new OutputView(), new Validators(), new Utils());
        lotto.start();
    }
}
