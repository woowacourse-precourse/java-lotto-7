package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoResultService;
import lotto.service.LottoSalesService;

public class LottoControllerConfig {
    private final LottoSalesService lottoSalesService;
    private final LottoResultService lottoResultService;

    public LottoControllerConfig(LottoSalesService lottoSalesService, LottoResultService lottoResultService) {
        this.lottoSalesService = lottoSalesService;
        this.lottoResultService = lottoResultService;
    }

    public LottoController lottoController() {
        return new LottoController(lottoSalesService, lottoResultService);
    }
}
