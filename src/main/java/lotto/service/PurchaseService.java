package lotto.service;

import lotto.domain.Money;
import lotto.validator.PurchaseValidator;

public class PurchaseService {
    private final PurchaseValidator purchaseValidator;

    public PurchaseService(PurchaseValidator purchaseValidator) {
        this.purchaseValidator = purchaseValidator;
    }

    public Money validateAndCreateMoney(String purchaseAmount) {
        purchaseValidator.validateProcess(purchaseAmount);
        return new Money(Integer.parseInt(purchaseAmount));
    }
}
