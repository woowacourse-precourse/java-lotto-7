package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

    public LottoService lottoService() {
        return new LottoService();
    }
}
