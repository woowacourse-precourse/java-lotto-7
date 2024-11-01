package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoGameController controller = appConfig.createLottoGameController();

        controller.run();
    }

}
