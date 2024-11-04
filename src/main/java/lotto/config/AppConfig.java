package lotto.config;

import lotto.controller.LottoController;
import lotto.generator.LottoGenerator;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.InputViewImpl;
import lotto.ui.ResultView;
import lotto.ui.ResultViewImpl;
import lotto.validation.Validator;
import lotto.validation.ValidatorImpl;

public class AppConfig {
    public LottoGenerator createLottoGenerator() {
        return new LottoGenerator();
    }

    public LottoService createLottoService() {
        return new LottoService(createLottoGenerator());
    }

    public InputView createInputView() {
        return new InputViewImpl();
    }

    public ResultView createResultView() {
        return new ResultViewImpl();
    }

    public Validator createValidator() {
        return new ValidatorImpl();
    }

    public LottoController createLottoController() {
        return new LottoController(createInputView(), createResultView(), createValidator(), createLottoService());
    }
}

