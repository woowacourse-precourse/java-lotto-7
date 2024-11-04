package lotto.config;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.console.ConsoleReader;
import lotto.view.console.ConsoleWriter;

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

