package lotto.domain;

import lotto.message.ErrorMessage;
import lotto.validation.Validator;

public class Amount {
    private final int amount;

    public Amount(String strAmount){
        this.amount = validateAmount(parseToInt(strAmount));
    }

    public int getAmount() {
        return amount;
    }

    private int parseToInt(String strAmount){
        try {
            return Integer.parseInt(strAmount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private int validateAmount(int amount){
        Validator.isPositive(amount);
        Validator.isDivisibleByThousand(amount);
        return amount;
    }
}
