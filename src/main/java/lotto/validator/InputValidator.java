package lotto.validator;

import static lotto.model.Constants.MULTIPLES_OF_LOTTO_PRICE;

import lotto.exception.InputException;
import lotto.message.ErrorMessage;

public class InputValidator {

    public static void isPurchaseAmountBlank(String input) {
        if(input.isBlank()) {
            throw new InputException(ErrorMessage.IS_BLANK_PURCHASE_AMOUNT.getMessage());
        }
    }

    public static void isMultiplesOfThousand(int purchaseAmount) {
        if(purchaseAmount % MULTIPLES_OF_LOTTO_PRICE != 0 || purchaseAmount < 1000) {
            throw new InputException(ErrorMessage.UNAVAILABLE_PURCHASE_AMOUNT.getMessage());
        }
    }
}
