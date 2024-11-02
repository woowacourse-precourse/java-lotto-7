package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;

public class ApplicationConfig {
    public LottoController lottoController() {
        return new LottoController(
                new InputView(),
                new LottoService()
        );
    }
}
