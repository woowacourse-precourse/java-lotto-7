package lotto.config;

import lotto.presentation.controller.LottoController;
import lotto.presentation.view.InputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView());
    }

    public InputView inputView() {
        return new InputView();
    }
}
