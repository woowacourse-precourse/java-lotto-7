package lotto;

import lotto.controller.LottoMachineController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new LottoMachineController(new InputView(), new OutputView()).run();
    }
}
