package lotto.application;

import lotto.controller.InputMiddleController;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutPutView;
import lotto.view.impl.InputViewImpl;
import lotto.view.impl.OutViewImpl;

public class LottoApplication {
    public void run() {
        InputView inputView = new InputViewImpl();
        OutPutView outputView = new OutViewImpl();
        InputMiddleController inputMiddleController = new InputMiddleController(inputView);
        LottoController lottoController = new LottoController(outputView, inputMiddleController);
        lottoController.run();
    }
}
