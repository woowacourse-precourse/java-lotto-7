package lotto.config;

import lotto.controller.LottoController;
import lotto.view.LottoInputView;

public class AppConfiguration {

    public LottoController lottoController() {
        return new LottoController(lottoInputView());
    }

    private LottoInputView lottoInputView() {
        return new LottoInputView();
    }
}
