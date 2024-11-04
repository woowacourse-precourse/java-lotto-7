package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getAppConfig();
        LottoController lottoController = appConfig.getLottoController();
        lottoController.lottoDraw();
    }
}
