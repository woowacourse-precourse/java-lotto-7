package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class AppConfiguration {

    public LottoController lottoController() {
        return new LottoController(lottoService(), lottoInputView(), lottoOutputView());
    }

    private LottoService lottoService() {
        return new LottoService();
    }

    private LottoInputView lottoInputView() {
        return new LottoInputView();
    }

    private LottoOutputView lottoOutputView() {
        return new LottoOutputView();
    }
}
