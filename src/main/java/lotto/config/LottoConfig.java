package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {
    public LottoController createLottoController() {
        return new LottoController(
                createLottoService(),
                createInputView(),
                createOutputView()
        );
    }

    private LottoService createLottoService() {
        return new LottoService(createLottoNumberGenerator());
    }

    private LottoNumberGenerator createLottoNumberGenerator() {
        return new LottoNumberGenerator();
    }

    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }
}
