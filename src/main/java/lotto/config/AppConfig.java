package lotto.config;

import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.controller.LottoController;

public class AppConfig {
    public InputView createInputView() {
        return new InputView();
    }

    public InputValidator createInputValidator() {
        return new InputValidator();
    }

    public LottoService createLottoService() {
        return new LottoService();
    }

    public LottoController createLottoController() {
        return new LottoController(createLottoService());
    }
}
