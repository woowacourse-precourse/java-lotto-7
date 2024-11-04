package lotto.config;

import lotto.winning.controller.WinningController;
import lotto.publishing.controller.PublishingController;
import lotto.purchasing.controller.PurchasingController;

public class LottoFactory {

    public void create() {
        PurchasingController purchasingController = new PurchasingController();
        purchasingController.purchaseLottoTickets();

        PublishingController publishingController = new PublishingController();
        publishingController.publishLottoTickets();
        WinningController winningController = new WinningController();
        winningController.presentRanksAndRates();
    }
}
