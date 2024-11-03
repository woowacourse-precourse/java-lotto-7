package lotto.validator;

import java.util.List;
import lotto.constants.InputError;
import lotto.constants.LottoInteger;
import lotto.view.ErrorPrinter;

public class BonusNumberValidator {
    private static String rawBonusNumber;
    private static int intBonusNumber;

    /**
     * 보너스 번호의 유효성 검사를 진행한다.
     * 
     * @param rawBonusNumber 유효성 검사가 필요한 보너스 번호
     * @param validWinNumbers 유효성 검사가 끝난 당첨 번호
     * @return 유효한 보너스 번호라면 true, 아닐 경우 false
     */

    public static boolean validate(String rawBonusNumber, List<Integer> validWinNumbers) {
        BonusNumberValidator.rawBonusNumber = rawBonusNumber;
        if (!isExist()) {
            return false;
        }
        if (!isDigit()) {
            return false;
        }
        if (!isOnlyOne(validWinNumbers)) {
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

    private static boolean isOnlyOne(List<Integer> validWinningNumbers) {
        if (!validWinningNumbers.contains(intBonusNumber)) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.BONUS_NUMBER_EXIST_IN_WIN_NUMBERS);
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
