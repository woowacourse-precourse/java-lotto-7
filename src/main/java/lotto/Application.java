package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoMachine;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(), new OutputView(), new LottoMachine()
        );
        lottoController.run();
    }
}
