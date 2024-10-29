package lotto.util;

import static lotto.constant.ErrorMessage.PRICE_TOO_LOW_ERROR;
import static lotto.constant.ErrorMessage.PRICE_TYPE_ERROR;

public class Validator {

    private static int THRESHOLD_PRICE = 1000;

    public boolean validatePrice(String price) {
        try{
            checkNumberType(price);
            checkPriceThreshold(price);
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



}
