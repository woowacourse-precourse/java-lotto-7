package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputView;

public class Application {
    public static void main(String[] args) {
        final LottoInputView inputView = new LottoInputView();
        LottoController lottoController = new LottoController(inputView);

        lottoController.start();
    }
}
