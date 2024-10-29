package lotto.util;

import static lotto.constant.ErrorMessage.*;

public class Validator {

    private static int THRESHOLD_PRICE = 1000;

    public boolean validatePrice(String price) {
        try{
            checkNumberType(price);
            checkPriceThreshold(price);
            checkPriceDivisible(price);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void checkNumberType(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(PRICE_TYPE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkPriceThreshold(String input) {
        int price = Integer.parseInt(input);
        if (price < THRESHOLD_PRICE) {
            System.out.println(PRICE_TOO_LOW_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkPriceDivisible(String input) {
        int price = Integer.parseInt(input);
        if (price % THRESHOLD_PRICE != 0) {
            System.out.println(PRICE_NOT_DIVISIBLE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public boolean validateWinningNumber(String input) {
        return true;
    }
}
