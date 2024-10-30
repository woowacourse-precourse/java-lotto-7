package lotto;

import lotto.controller.domain.LottoController;
import lotto.controller.service.LottoControllerFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = LottoControllerFactory.create();
        lottoController.run();
    }
}
