package lotto;

import lotto.config.LottoControllerConfig;
import lotto.controller.LottoController;
import lotto.service.LottoResultService;
import lotto.service.LottoSalesService;

public class Application {
    public static void main(String[] args) {
        LottoControllerConfig lottoControllerConfig = new LottoControllerConfig(
                new LottoSalesService(),
                new LottoResultService()
        );

        LottoController lottoController = lottoControllerConfig.lottoController();
        lottoController.run();
    }
}
