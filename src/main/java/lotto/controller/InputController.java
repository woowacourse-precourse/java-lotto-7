package lotto.controller;

import lotto.util.MoneyValidator;
import lotto.view.PurchaseView;

public class InputController {

    private final PurchaseView purchaseView;

    public InputController(final PurchaseView purchaseView) {
        this.purchaseView = purchaseView;
    }

    public int getMoney() {
        while (true) {
            try {
                String money = purchaseView.getMoney();
                return MoneyValidator.validate(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
