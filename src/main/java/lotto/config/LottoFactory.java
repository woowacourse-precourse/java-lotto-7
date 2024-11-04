package lotto.config;

import java.util.List;
import lotto.winning.WinningController;
import lotto.common.model.Lotto;
import lotto.publishing.controller.PublishingController;
import lotto.purchasing.controller.PurchasingController;

public class LottoFactory {

    public void create() {
        PurchasingController purchasingController = new PurchasingController();
        purchasingController.purchaseLottoTickets();

        PublishingController publishingController = new PublishingController();
        List<Lotto> LottoTickets = publishingController.publishLottoTickets();

        WinningController winningController = new WinningController(LottoTickets);
        winningController.presentRanksAndRates();
    }
}
