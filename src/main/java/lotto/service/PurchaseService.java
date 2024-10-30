package lotto.service;

import lotto.domain.Money;
import lotto.utils.Parser;
import lotto.validator.PurchaseValidator;

public class PurchaseService {

    public Money purchaseMoney(String purchaseAmount) {
        int convertedPurchaseAmount = Parser.parsingPurchaseAmount(purchaseAmount);
        PurchaseValidator.validateProcess(convertedPurchaseAmount);
        return new Money(Integer.parseInt(purchaseAmount));
    }
}
