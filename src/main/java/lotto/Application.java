package lotto;

import lotto.controller.LottoController;
import lotto.enums.LottoConfig;
import lotto.handler.RetryHandler;
import lotto.view.LottoInputParser;
import lotto.view.LottoInputValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoConfig config = LottoConfig.WOOWA_CONFIG;
        LottoController controller = new LottoController(
                new LottoInputView(new LottoInputValidator(), new LottoInputParser(config)),
                new LottoOutputView(),
                new RetryHandler(),
                config
        );
        controller.run();
    }
}
