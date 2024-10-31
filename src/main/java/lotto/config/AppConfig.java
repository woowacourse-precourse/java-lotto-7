package lotto.config;

import lotto.controller.LottoController;
import lotto.view.InputView;

public class AppConfig {

    private static final AppConfig appConfig = new AppConfig();

    public LottoController getLottoController() {
        return new LottoController(getInputView());
    }

    private InputView getInputView() {
        return new InputView();
    }
}
