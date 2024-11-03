package config;

import controller.LottoController;
import service.LottoService;
import view.InputView;
import view.OutputView;

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
                inputView(), outputView(), lottoService()
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
}
