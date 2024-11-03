package lotto;

import lotto.config.AppConfig;
import lotto.presentation.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.lottoController();
        lottoController.start();
    }
}
