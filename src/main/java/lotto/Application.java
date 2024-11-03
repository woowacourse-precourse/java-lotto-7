package lotto;

import lotto.controller.LottoController;
import lotto.factory.WoowaLottoControllerFactory;

public class Application {
    public static void main(String[] args) {
        LottoController controller = WoowaLottoControllerFactory.create();
        controller.run();
    }
}
