package lotto.validation;

import lotto.utils.Utils;

import static lotto.message.ErrorMessage.*;

public class UserValidation {

    public static void validateBuyAmount(int buyAmount){
        validateBuyAmountRange(buyAmount);
        validateBuyAmountThousandUnit(buyAmount);
    }

    private static void validateBuyAmountThousandUnit(int buyAmount) {
        if(isNotDivisibleByThousand(buyAmount)){
            Utils.print(BUY_AMOUNT_NOT_THOUSAND_UNIT.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotDivisibleByThousand(int buyAmount) {
        return buyAmount % 1000 != 0;
    }

    private static void validateBuyAmountRange(int buyAmount){
        if(isLessThanThousand(buyAmount)){
            Utils.print(BUY_AMOUNT_LESS_THAN_THOUSAND.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLessThanThousand(int buyAmount){
        return buyAmount < 1000;
    }
}
