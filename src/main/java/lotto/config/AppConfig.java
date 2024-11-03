package lotto.config;

import lotto.ui.LottoController;
import lotto.app.DefaultRandomValueGenerator;
import lotto.app.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public InputView inputView() {
        return new InputView(inputValidator());
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), lottoService());
    }

    public LottoService lottoService() {
        return new LottoService(randomValueGenerator());
    }

    public DefaultRandomValueGenerator randomValueGenerator() {
        return new DefaultRandomValueGenerator();
    }
}
