package lotto;

import lotto.config.Config;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = Config.createLottoController();
        lottoController.run();
    }
}
