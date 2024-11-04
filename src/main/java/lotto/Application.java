package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoInputView(), new LottoOutputView(),
                new LottoService());
        lottoController.run();
    }
}
