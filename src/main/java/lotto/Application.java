package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.view.InputHelper;
import lotto.view.OutputHelper;

public class Application {
    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();
        OutputHelper outputHelper = new OutputHelper();
        LottoMachine lottoMachine = new LottoMachine();

        LottoController lottoController = new LottoController(
                inputHelper, outputHelper, lottoMachine
        );

        lottoController.run();
    }
}
