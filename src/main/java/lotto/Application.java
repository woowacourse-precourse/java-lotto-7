package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoController lottoController = new LottoController(inputView, lottoMachine);

        lottoController.run();
    }
}
