package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessages;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class BonusNumberValidator {

    public static int validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        int bonusNumber = parseBonusNumber(bonusNumberInput);
        checkBonusNumberRange(bonusNumber);
        checkBonusNumberDuplication(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int parseBonusNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessages.ERROR_NON_INTEGER_BONUS_NUMBER);
        }
    }

    private static void checkBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new InputException(ErrorMessages.ERROR_BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private static void checkBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new InputException(ErrorMessages.ERROR_DUPLICATE_BONUS_NUMBER);
        }
    }
}
