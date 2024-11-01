package lotto;

import lotto.controller.LottoGameController;
import lotto.service.BuyerService;
import lotto.service.LottoService;
import lotto.service.StatService;

public class Application {
    public static void main(String[] args) {
        final BuyerService buyerService = new BuyerService();
        final LottoService lottoService = new LottoService();
        final StatService statService = new StatService();

        LottoGameController lottoGameController = new LottoGameController(buyerService, lottoService, statService);
        lottoGameController.run();
    }
}
