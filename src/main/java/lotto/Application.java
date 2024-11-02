package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.service.LottoResultService;
import lotto.service.LottoSalesService;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig(
                new LottoSalesService(),
                new LottoResultService()
        );

        LottoController lottoController = appConfig.lottoController();
        lottoController.run();
    }
}
