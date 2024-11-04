package lotto.utils;

import lotto.exception.LottoException;

public class PurchaseAmount {

    public static boolean validateInput(String purchaseAmount) {

        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(LottoException.PURCHASE_AMOUNT_IS_EMPTY));
        }

        try {
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static int validatePurchaseAmount(String purchaseAmount) {
        int castedPurchaseAmount = Integer.parseInt(purchaseAmount);

        if (castedPurchaseAmount == 0) {
            throw new IllegalArgumentException(String.valueOf(LottoException.PURCHASE_AMOUNT_IS_ZERO));
        }
        if (castedPurchaseAmount < 0) {
            throw new IllegalArgumentException(String.valueOf(LottoException.PURCHASE_AMOUNT_IS_NEGATIVE));
        }
        if (castedPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(String.valueOf(LottoException.PURCHASE_AMOUNT_IS_INVALID));
        }

        return castedPurchaseAmount;
    }

    public static int calculateNumberOfLotteryTickets(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
    
}
