package lotto.common.config;

import lotto.domain.controller.LottoController;
import lotto.domain.model.LottoGenerator;
import lotto.domain.model.LottoService;
import lotto.domain.view.InputView;

public class Factory {

    public LottoController lottoController() {
        return new LottoController(inputView(), lottoService());
    }

    public InputView inputView() {
        return new InputView();
    }

    public LottoService lottoService() {
        return new LottoService(lottoGenerator());
    }

    public LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }
}
