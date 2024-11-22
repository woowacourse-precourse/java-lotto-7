package lotto;

import lotto.controller.Controller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new Controller(new InputView(), new OutputView()).run();
    }
}
