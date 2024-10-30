package lotto.common.config;

import lotto.domain.controller.LottoController;
import lotto.domain.model.LottoGenerator;
import lotto.domain.model.LottoService;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

public class Factory {

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView(), outputView());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoService lottoService() {
        return new LottoService(lottoGenerator());
    }

    public LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }
}
