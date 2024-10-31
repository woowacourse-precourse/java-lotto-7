package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            int amount = InputView.inputPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }
}
