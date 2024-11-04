package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoBuyService;
import lotto.service.LottoCheckService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController getLottoController() {
        return new LottoController(new InputView(), new OutputView(), new LottoBuyService(), new LottoCheckService());
    }
}
