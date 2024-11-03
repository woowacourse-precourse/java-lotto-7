package lotto.validation;

import lotto.message.ErrorMessage;

public class Validator {

    private static final int LOTTO_PRICE = 1000;

    public static void isPositive(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    public static void isDivisibleByThousand(int amount){
        if(amount % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_THOUSAND.getMessage());
        }
    }

}
