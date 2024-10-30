package lotto.service;

import lotto.validator.PurchaseValidator;

public class PurchaseService {
    private final PurchaseValidator purchaseValidator;

    public PurchaseService(PurchaseValidator purchaseValidator) {
        this.purchaseValidator = purchaseValidator;
    }

    public void processPurchase(String purchaseAmount) {

    }
}
