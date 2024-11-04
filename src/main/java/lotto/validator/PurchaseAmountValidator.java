package lotto.validator;

import static lotto.message.ErrorMessage.CAN_NOT_PURCHASE;
import static lotto.message.ErrorMessage.PARSE_INT_ERROR;

import lotto.domain.Lotto;

public class PurchaseAmountValidator {
    private int purchaseAmount = 0;

    public boolean isNotValidPurchaseAmount(String userInput) {
        if (isNotParsableToPurchaseAmount(userInput)) {
            return true;
        }
        return canNotPurchase(purchaseAmount);
    }

    private boolean isNotParsableToPurchaseAmount(String userInput) {
        try {
            purchaseAmount = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(PARSE_INT_ERROR.getMessage());
            return true;
        }
        return false;
    }

    private boolean canNotPurchase(int purchaseAmount) {
        try {
            if (purchaseAmount < Lotto.LOTTO_UNIT_PRICE || (purchaseAmount % Lotto.LOTTO_UNIT_PRICE) != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(CAN_NOT_PURCHASE.getMessage());
            return true;
        }
        return false;
    }
}
