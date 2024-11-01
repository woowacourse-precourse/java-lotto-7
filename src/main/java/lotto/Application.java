package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoInputView lottoInputView = new LottoInputView();

        LottoController lottoController = new LottoController(lottoOutputView, lottoInputView);
        lottoController.run();
    }
}
