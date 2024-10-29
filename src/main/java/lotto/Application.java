package lotto;

import lotto.common.config.Factory;
import lotto.domain.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        Factory factory = new Factory();

        LottoController lottoController = factory.lottoController();
        lottoController.run();
    }
}
