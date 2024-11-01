package lotto.config;

import lotto.controller.LottoController;
import lotto.view.InputView;

public class ApplicationConfig {
    public LottoController lottoController() {
        return new LottoController(new InputView());
    }
}
