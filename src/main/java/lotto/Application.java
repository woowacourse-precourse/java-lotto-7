package lotto;

import lotto.config.ApplicationConfig;
import lotto.controller.LottoController;

public class Application {
    private static final ApplicationConfig config = new ApplicationConfig();

    public static void main(String[] args) {
        LottoController controller = config.createLottoController();
        controller.run();
    }
}
