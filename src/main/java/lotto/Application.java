package lotto;

import lotto.controller.LottoGameController;
import lotto.service.BuyerService;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        final BuyerService buyerService = new BuyerService();
        final LottoService lottoService = new LottoService();

        LottoGameController lottoGameController = new LottoGameController(buyerService, lottoService);
        lottoGameController.run();
    }
}
