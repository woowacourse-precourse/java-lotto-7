package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoInputView());
        lottoController.run();
    }
}
