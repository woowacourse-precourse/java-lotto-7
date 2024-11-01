package lotto;

import lotto.controller.LottoController;
import lotto.enums.LottoConfig;
import lotto.handler.RetryHandler;
import lotto.view.LottoInputValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new LottoInputView(new LottoInputValidator()),
                new LottoOutputView(),
                new RetryHandler(),
                LottoConfig.WOOWA_CONFIG
        );
        controller.run();
    }
}
