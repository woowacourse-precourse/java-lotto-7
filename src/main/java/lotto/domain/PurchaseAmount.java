package lotto.domain;

import lotto.error.ErrorCode;

public class PurchaseAmount {

    private int amount;

    public PurchaseAmount(String amount) {
        int tempAmount = validateAndGetIsInt(amount);
        validateIsPositive(tempAmount);
        validateMultipleOf1000(tempAmount);
        this.amount = tempAmount;
    }

    private int validateAndGetIsInt(String amount){
        try {
            return  Integer.parseInt(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NOT_INTEGER.getMessage());
        }
    }

    private void validateIsPositive(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorCode.NOT_POSITIVE.getMessage());
        }
    }

    private void validateMultipleOf1000(int amount){
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorCode.NOT_MULTIPLE_OF_1000.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
