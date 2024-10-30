package lotto.service;

import lotto.domain.PurchaseAmount;

public class LottoService {
    private final PurchaseAmount purchaseAmount;

    public LottoService(double purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
    }
}
