package lotto;

import lotto.controller.LottoController;
import lotto.service.DrawService;
import lotto.service.LottoSellingService;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoSellingService(), new DrawService());

        lottoController.run();
    }
}
