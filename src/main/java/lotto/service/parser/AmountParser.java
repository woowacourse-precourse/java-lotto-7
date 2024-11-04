package lotto.service.parser;

import lotto.validation.AmountValidator;

public class AmountParser {

    public static int parseAmount(String amountInput){
        int amount = Integer.parseInt(amountInput.trim());
        AmountValidator.validateAmount(amount);
        return amount;
    }
}
