package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoResultService;
import lotto.service.LottoSalesService;

public class AppConfig {
    private final LottoSalesService lottoSalesService;
    private final LottoResultService lottoResultService;

    public AppConfig(LottoSalesService lottoSalesService, LottoResultService lottoResultService) {
        this.lottoSalesService = lottoSalesService;
        this.lottoResultService = lottoResultService;
    }

    public LottoController lottoController() {
        return new LottoController(lottoSalesService, lottoResultService);
    }
}
