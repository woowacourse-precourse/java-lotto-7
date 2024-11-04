package lotto;

import lotto.common.config.LottoFactory;
import lotto.presentation.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoFactory.createLottoController();
        lottoController.run();
    }
}
