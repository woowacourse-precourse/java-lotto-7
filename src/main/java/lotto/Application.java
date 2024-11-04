package lotto;

import lotto.config.LottoControllerFactory;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoControllerFactory.create();
        lottoController.run();
    }
}
