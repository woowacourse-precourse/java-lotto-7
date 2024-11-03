package lotto.service;

import lotto.domain.Purchase;
import lotto.view.InputView;

public class PurchaseService {

    public Purchase purchaseLotto(int purchaseAmountNumber) {
        Purchase purchase = null;
        while (purchase == null) {
            try {
                purchase = new Purchase(purchaseAmountNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                purchaseAmountNumber = InputView.getPurchaseAmount();
            }
        }
        return purchase;
    }
}
