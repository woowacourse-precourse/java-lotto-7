package lotto.validator;

import lotto.constant.Constant;
import lotto.error.ErrorMessage;

public class LottoPurchaseValidator {

    public static void validate(String lottoPrice) {
        if(!validateNotBlank(lottoPrice)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }
        if(!validateNumberFormat(lottoPrice)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_CHARS.getMessage());
        }
        if(!validateCurrencyUnit(lottoPrice)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_1000WON_UNIT.getMessage());
        }
        if(!validateAmountNotExceeded(lottoPrice)) {
            throw new IllegalArgumentException(ErrorMessage.EXCESS_PRICE.getMessage());
        }
    }

    private static boolean validateNotBlank(String lottoPrice) {
        return !lottoPrice.isBlank();
    }

    private static boolean validateNumberFormat(String lottoPrice) {
        try{
            Integer.parseInt(lottoPrice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean validateCurrencyUnit(String lottoPrice) {
        int price = Integer.parseInt(lottoPrice);
        return price % Constant.WON_UNIT == 0;
    }

    private static boolean validateAmountNotExceeded(String lottoPrice) {
        int price = Integer.parseInt(lottoPrice);
        return price <= Constant.MAX_PRICE;
    }
}
