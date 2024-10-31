package lotto.config;

import lotto.controller.LottoController;
import lotto.view.ErrorView;
import lotto.view.InputView;

public class AppConfig {

    private static final AppConfig appConfig = new AppConfig();

    public LottoController getLottoController() {
        return new LottoController(getInputView(), getErrorView());
    }

    private InputView getInputView() {
        return new InputView();
    }

    private ErrorView getErrorView() {
        return new ErrorView();
    }
}
