package lotto.validator;

import lotto.constants.InputError;
import lotto.constants.LottoInteger;
import lotto.view.ErrorPrinter;

public class BonusNumberValidator {
    private static String rawBonusNumber;
    private static int intBonusNumber;

    public static boolean validate(String rawBonusNumber) {
        BonusNumberValidator.rawBonusNumber = rawBonusNumber;
        if (!isExist()) {
            return false;
        }
        if (!isDigit()) {
            return false;
        }
        if (!isValidRange()) {
            return false;
        }
        return true;
    }

    private static boolean isExist() {
        if (!rawBonusNumber.isBlank()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.BONUS_NUMBER_SHOULD_EXIST);
        return false;
    }

    private static boolean isDigit() {
        try {
            intBonusNumber = Integer.parseInt(rawBonusNumber);
            return true;
        } catch (NumberFormatException exception) {
            ErrorPrinter.errorPrint(InputError.BONUS_NUMBER_NOT_A_NUMBER);
        }
        return false;
    }

    private static boolean isValidRange() {
        if (intBonusNumber >= LottoInteger.LOTTO_START_NUMBER.getValue()
                && intBonusNumber <= LottoInteger.LOTTO_END_NUMBER.getValue()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.BONUS_NUMBER_NOT_IN_BETWEEN_START_AND_END);
        return false;
    }
}
