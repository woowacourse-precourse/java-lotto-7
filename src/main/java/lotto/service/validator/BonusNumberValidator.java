package lotto.service.validator;

import lotto.util.ErrorMessage;
import lotto.util.LottoNumber;

public class BonusNumberValidator {
    public static boolean validateBlank(String bonusNUmber) {
        try {
            if (bonusNUmber.isBlank()) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.ERROR_EMPTY_BONUS_NUMBER);
            return false;
        }
    }
    public static boolean validateDataType(String bonusNUmber) {
        try {
            Integer.parseInt(bonusNUmber);
            return true;
        } catch (NumberFormatException err) {
            System.out.println(ErrorMessage.ERROR_INVALID_BONUS_NUMBER_FORMAT);
            return false;
        }
    }
    public static boolean validateRange(String bonusNUmber) {
        try {
            int parsedNumber = Integer.parseInt(bonusNUmber);
            if (parsedNumber < LottoNumber.MIN_LOTTO_NUMBER || parsedNumber > LottoNumber.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.ERROR_BONUS_NUMBER_OUT_OF_RANGE);
            return false;
        }
    }
}
