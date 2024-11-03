package lotto;

import lotto.controller.LottoController;
import lotto.factory.LottoFactory;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = LottoFactory.createLottoController();
        lottoController.start();
    }
}
