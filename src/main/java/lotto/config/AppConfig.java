package lotto.config;

import lotto.controller.LottoController;
import lotto.model.service.LottServiceImpl;
import lotto.model.service.LottoService;
import lotto.view.inputview.InputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView());
    }

    public LottoService lottoService() {
        return new LottServiceImpl();
    }

    public InputView inputView() {
        return new InputView();
    }
}
