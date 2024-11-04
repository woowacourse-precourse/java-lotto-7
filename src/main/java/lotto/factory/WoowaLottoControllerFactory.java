package lotto.factory;

import lotto.controller.LottoController;
import lotto.enums.LottoConfig;
import lotto.handler.RetryHandler;
import lotto.view.LottoInputParser;
import lotto.view.LottoInputValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class WoowaLottoControllerFactory {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;

    public static LottoController create() {
        LottoInputView lottoInputView = new LottoInputView(new LottoInputValidator(), new LottoInputParser(CONFIG));
        LottoOutputView lottoOutputView = new LottoOutputView();
        RetryHandler retryHandler = new RetryHandler();

        return new LottoController(lottoInputView, lottoOutputView, retryHandler, CONFIG);
    }
}
