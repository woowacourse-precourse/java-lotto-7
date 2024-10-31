package lotto.validation;

import lotto.exception.ErrorMessage;

public class AmountValidator {

    public static void validateAmount(int amount) {
        if (isThousand(amount)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND.toString());
        }
    }

    private static boolean isThousand(int amount) {
        return amount % 1000!=0;
    }
}
