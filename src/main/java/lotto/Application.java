package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController controller = AppConfig.createLottoGameController();

        controller.run();
    }

}
