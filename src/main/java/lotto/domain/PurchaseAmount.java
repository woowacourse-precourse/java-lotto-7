package lotto.domain;

import lotto.error.ErrorCode;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int AVAILABLE_MIN_AMOUNT = 1000;
    private int amount;

    public PurchaseAmount(String amount) {
        int tempAmount = validateAndGetIsInt(amount);
        validateIsAvailableMinAmount(tempAmount);
        validateMultipleOfLOTTO_PRICE(tempAmount);
        this.amount = tempAmount;
    }

    private int validateAndGetIsInt(String amount){
        try {
            return  Integer.parseInt(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NOT_INTEGER.getMessage());
        }
    }

    private void validateIsAvailableMinAmount(int amount){
        if (amount < AVAILABLE_MIN_AMOUNT) {
            throw new IllegalArgumentException(ErrorCode.UNAVAILABLE_MIN_AMOUNT.getMessage());
        }
    }

    private void validateMultipleOfLOTTO_PRICE(int amount){
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
