package lotto.controller;

import lotto.model.PurchaseLotto;
import lotto.view.PurchaseView;

public class InputController {

    private final PurchaseView purchaseView;

    public InputController(final PurchaseView purchaseView) {
        this.purchaseView = purchaseView;
    }

    public PurchaseLotto moneyToLottoList() {
        while (true) {
            try {
                String money = purchaseView.getMoney();
                return new PurchaseLotto(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
