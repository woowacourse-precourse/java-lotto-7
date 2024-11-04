package lotto;

import lotto.controller.LottoController;
import lotto.domain.PurchaseLotto;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new PurchaseLotto());
        lottoController.run();
    }
}
