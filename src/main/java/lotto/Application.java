package lotto;

import lotto.mvc.controller.LottoController;
import lotto.mvc.view.InputView;
import lotto.mvc.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView());

        lottoController.run();
    }
}
