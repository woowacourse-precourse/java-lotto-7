package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class AppConfig {
    private final LottoService lottoService;

    public AppConfig(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoController lottoController() {
        return new LottoController(lottoService);
    }
}
