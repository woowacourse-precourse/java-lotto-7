package domain;

import message.ErrorMessage;

public class PlayerBuyLotto {

    public int buyLotto(String purchaseAmount) {

        validatePurchaseAmount(purchaseAmount);

        int amount = Integer.parseInt(purchaseAmount);
        int LottoPurchased = amount % 1000;

        return LottoPurchased;
    }

    private void validatePurchaseAmount(String purchaseAmount) {

        int amount;

        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_LETTER.getErrorMessage());
        }

        if(amount % 100 != 0){
            throw new IllegalArgumentException(ErrorMessage.CANNOT_BUY_LOTTO.getErrorMessage());
        }
    }
}
