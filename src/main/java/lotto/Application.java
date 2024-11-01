package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        LottoController lottoController = config.getLottoController();
        lottoController.start();
    }
}
