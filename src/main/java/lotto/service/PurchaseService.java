package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class PurchaseService {
    public Integer purchaseLotto(String rawPurchaseAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(rawPurchaseAmount);

        return purchaseAmount.getAmount();
    }
}
