package lotto;

import lotto.global.config.AppConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = AppConfig.INSTANCE.createLottoController();
        lottoController.start();
    }
}
