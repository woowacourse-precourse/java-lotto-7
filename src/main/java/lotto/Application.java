package lotto;

import lotto.config.Config;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        LottoController lottoController = config.lottoController();
        lottoController.run();
    }
}
