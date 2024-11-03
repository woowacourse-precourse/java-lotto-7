package lotto.config;

import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.controller.LottoController;
import lotto.view.OutputView;

public class AppConfig {
    public InputView createInputView() {
        return new InputView();
    }

    public InputValidator createInputValidator() {
        return new InputValidator();
    }

    public OutputView createOutputView() {
        return new OutputView();
    }

    public LottoService createLottoService() {
        return new LottoService();
    }

    public LottoController createLottoController() {
        return new LottoController(createLottoService());
    }

    public AppRunner createAppRunner() {
        return new AppRunner(createInputView(), createInputValidator(), createOutputView(), createLottoController());
    }
}
