package lotto.config;

import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.controller.LottoController;
import lotto.view.OutputView;

public class AppConfig {
    public AppRunner createAppRunner() {
        return new AppRunner(createInputView(), createInputValidator(), createOutputView(), createLottoController());
    }

    private InputView createInputView() {
        return new InputView();
    }

    private InputValidator createInputValidator() {
        return new InputValidator();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }

    private LottoService createLottoService() {
        return new LottoService();
    }

    private LottoController createLottoController() {
        return new LottoController(createLottoService());
    }
}