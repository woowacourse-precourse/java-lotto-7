package lotto.controller;

import lotto.view.PurchaseView;

public class LottoController {

    private final PurchaseView purchaseView;

    public LottoController(final PurchaseView purchaseView) {
        this.purchaseView = purchaseView;
    }

    public void run() {
        String moneyTemp = purchaseView.getMoney();
    }
}
