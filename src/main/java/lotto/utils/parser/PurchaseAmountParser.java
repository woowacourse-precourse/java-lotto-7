package lotto.utils.parser;

import lotto.utils.validator.PurchaseAmountValidator;

public class PurchaseAmountParser {
    private final PurchaseAmountValidator validator;

    public PurchaseAmountParser(PurchaseAmountValidator purchaseAmountValidator) {
        this.validator = purchaseAmountValidator;
    }

    public int parse(String userInput) {
        validator.validate(userInput);

        int purchaseAmount = Integer.parseInt(userInput);
        validator.validateDivisibleByThousand(purchaseAmount);

        return purchaseAmount;
    }
}
