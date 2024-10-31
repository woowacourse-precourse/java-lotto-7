package lotto;

import lotto.mvc.controller.LottoController;
import lotto.mvc.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView());

        lottoController.run();
    }
}
