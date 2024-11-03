package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private AppConfig() {}

    public static class AppConfigHolder {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return AppConfigHolder.INSTANCE;
    }

    public LottoController lottoController() {
        return new LottoController(
                inputView(), outputView(), lottoService(), resultService()
        );
    }

    private InputView inputView() {
        return InputView.getInstance();
    }

    private OutputView outputView() {
        return OutputView.getInstance();
    }

    private LottoService lottoService() {
        return new LottoService();
    }

    private ResultService resultService() {
        return new ResultService();
    }
}
