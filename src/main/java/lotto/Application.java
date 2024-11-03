package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = LottoControllerFactory.getLottoController();
        lottoController.run();
    }
}
