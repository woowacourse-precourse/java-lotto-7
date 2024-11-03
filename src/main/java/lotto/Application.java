package lotto;

import lotto.controller.LottoController;
import lotto.config.ObjectFactory;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = ObjectFactory.createLottoController();
        lottoController.run();
    }
}
