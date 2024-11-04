package config;

import controller.LottoController;
import view.InputView;
import view.OutputView;
import view.console.ConsoleReader;
import view.console.ConsoleWriter;

public class AppConfig {
    private AppConfig() {
    }

    private static class SingleTonHelper {
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance() {
        return SingleTonHelper.INSTANCE;
    }

    public LottoController lottoController() {
        return new LottoController(createInputView(), createOutputView());
    }

    private InputView createInputView() {
        return new ConsoleReader();
    }

    private OutputView createOutputView() {
        return new ConsoleWriter();
    }
}

