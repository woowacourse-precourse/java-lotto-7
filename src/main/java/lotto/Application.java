package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig(
                new LottoService()
        );

        LottoController lottoController = appConfig.lottoController();
        lottoController.run();
    }
}
