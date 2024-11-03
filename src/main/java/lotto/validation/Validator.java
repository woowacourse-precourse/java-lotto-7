package lotto.validation;

import lotto.message.ErrorMessage;

public class Validator {

    private static final int MINIMUM_AMOUNT = 1000;
    private static final int THOUSAND_DIVISOR = 1000;

    public static void isPositive(int amount){
        if(amount < MINIMUM_AMOUNT){
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    public static void isDivisibleByThousand(int amount){
        if(amount % THOUSAND_DIVISOR != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_THOUSAND.getMessage());
        }
    }
}
