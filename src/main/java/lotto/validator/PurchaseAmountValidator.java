package lotto.validator;

import static lotto.message.ErrorMessage.CAN_NOT_PURCHASE;
import static lotto.message.ErrorMessage.PARSE_INT_ERROR;

public class PurchaseAmountValidator {

    private int purchaseAmount = 0;

    public boolean isNotValidPurchaseAmount(String userInput) {
        if (isNotParsableToPurchaseAmount(userInput)) {
            return true;
        }
        if (canNotPurchase(purchaseAmount)) {
            return true;
        }
        return false;
    }

    private boolean isNotParsableToPurchaseAmount(String userInput) {
        try {
            purchaseAmount = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(PARSE_INT_ERROR.getMassage());
            return true;
        }
        return false;
    }

    private boolean canNotPurchase(int purchaseAmount) {
        try {
            if (purchaseAmount < 1000 || (purchaseAmount % 1000) != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(CAN_NOT_PURCHASE.getMassage());
            return true;
        }
        return false;
    }
}
