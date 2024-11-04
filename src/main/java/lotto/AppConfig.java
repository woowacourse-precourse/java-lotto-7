package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.StatsService;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(lottoService(), statsService());
    }

    private LottoService lottoService() {
        return new LottoService();
    }

    private StatsService statsService() {
        return new StatsService();
    }
}
