package lotto;

import lotto.controller.LottoController;
import lotto.model.Lotto;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
