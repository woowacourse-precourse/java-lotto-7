package lotto.service;

import lotto.validation.InputValidation;
import lotto.validation.PurchasePriceValidation;

public class LottoService {

    private final InputValidation inputValidation;
    private final PurchasePriceValidation purchasePriceValidation;

    public LottoService() {
        this.inputValidation = new InputValidation();
        this.purchasePriceValidation = new PurchasePriceValidation();
    }

    public int validatePurchasePrice(String purchasePriceInput) throws IllegalArgumentException {
        inputValidation.checkNotNullAndNotBlank(purchasePriceInput);
        purchasePriceValidation.checkIsInteger(purchasePriceInput);

        int purchasePrice = Integer.parseInt(purchasePriceInput);

        purchasePriceValidation.checkRange(purchasePrice);
        purchasePriceValidation.validateDivisibleByThousand(purchasePrice);

        return purchasePrice / 1000;
    }

}
