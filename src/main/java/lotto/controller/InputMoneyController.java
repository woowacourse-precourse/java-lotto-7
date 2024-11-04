package lotto.controller;

import lotto.util.MoneyValidator;
import lotto.util.ViewUtil;
import lotto.view.PurchaseView;

public class InputMoneyController {

    private final PurchaseView purchaseView;

    public InputMoneyController(final PurchaseView purchaseView) {
        this.purchaseView = purchaseView;
    }

    public int getMoney() {
        while (true) {
            try {
                String money = purchaseView.getMoney();
                ViewUtil.printEmptyLine();
                return MoneyValidator.validate(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
