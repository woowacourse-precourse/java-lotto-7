package lotto.app;

import lotto.config.AppConfig;
import lotto.service.LottoService;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class Application {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoService lottoService;

    public Application(InputHandler inputHandler, OutputHandler outputHandler, LottoService lottoService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoService = lottoService;
    }

    public static void main(String[] args) {
        Application application = AppConfig.createApplication();
        application.run();
    }

    public void run() {
    }
}