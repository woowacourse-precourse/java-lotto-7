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
            System.out.println(ErrorMessage.EMPTY_BONUS_NUMBER_STRING_ERROR);
            return false;
        }
    }
    public static boolean validateDataType(String bonusNUmber) {
        try {
            Integer.parseInt(bonusNUmber);
            return true;
        } catch (NumberFormatException err) {
            System.out.println(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT_ERROR);
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
            System.out.println(ErrorMessage.INVALID_BONUS_NUMBER_RANGE_ERROR);
            return false;
        }
    }
}
