package lotto.config;

import lotto.controller.LottoController;
import lotto.model.LottoGenerator;
import lotto.service.LottoService;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private static final AppConfig appConfig = new AppConfig();

    public static AppConfig getAppConfig() {
        return appConfig;
    }

    public LottoController getLottoController() {
        return new LottoController(getInputView(), getOutputview(), getErrorView(), getLottoService());
    }

    private InputView getInputView() {
        return new InputView();
    }

    private OutputView getOutputview() {
        return new OutputView();
    }

    private ErrorView getErrorView() {
        return new ErrorView();
    }

    private LottoService getLottoService() {
        return new LottoService(getLottoGenerator());
    }

    private LottoGenerator getLottoGenerator() {
        return new LottoGenerator();
    }
}
