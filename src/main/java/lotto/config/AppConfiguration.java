package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoInputView;

public class AppConfiguration {

    public LottoController lottoController() {
        return new LottoController(lottoService(), lottoInputView());
    }

    private LottoService lottoService() {
        return new LottoService();
    }

    private LottoInputView lottoInputView() {
        return new LottoInputView();
    }
}
