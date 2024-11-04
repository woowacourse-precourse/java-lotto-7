package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoController lottoController = new LottoController(lottoInputView, lottoOutputView);
        lottoController.run();
    }
}
