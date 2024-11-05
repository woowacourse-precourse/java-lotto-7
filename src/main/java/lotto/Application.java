package lotto;

import lotto.mvc.controller.InputHandler;
import lotto.mvc.controller.LottoController;
import lotto.mvc.model.LottoManager;
import lotto.mvc.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputHandler(), new OutputView(), new LottoManager());

        lottoController.run();
    }
}
