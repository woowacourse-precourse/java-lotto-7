package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoController.LottoControllerHolder;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoControllerHolder.LOTTO_CONTROLLER;
        lottoController.run();
    }
}
