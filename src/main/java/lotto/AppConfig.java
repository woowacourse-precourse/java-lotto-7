package lotto;

import lotto.handler.LottoController;
import lotto.handler.RandomValueGenerator;
import lotto.service.LottoService;
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

    public RandomValueGenerator randomValueGenerator() {
        return new RandomValueGenerator();
    }
}
