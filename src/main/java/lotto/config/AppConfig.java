package lotto.config;

import lotto.controller.LottoController;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.LottoView;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(inputView(),lottoView(),lottoService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private LottoView lottoView() {
        return new LottoView();
    }

    private LottoService lottoService() {
        return new LottoService();
    }
}
