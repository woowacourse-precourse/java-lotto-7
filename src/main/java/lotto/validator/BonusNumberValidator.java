package lotto.validator;

import static lotto.message.CommonConstants.LOTTO_MAX_NUMBER;
import static lotto.message.CommonConstants.LOTTO_MIN_NUMBER;
import static lotto.message.ErrorMessage.ERROR_BONUS_NUMBER_RANGE;
import static lotto.message.ErrorMessage.ERROR_DUPLICATE_BONUS_NUMBER;
import static lotto.message.ErrorMessage.ERROR_EMPTY_BONUS_NUMBER;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class BonusNumberValidator {

    public static void validateInputBonusNumber(String inputBonusNumber) {
        validateNotEmpty(inputBonusNumber);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicateNumber(winningNumbers, bonusNumber);
    }

    private static void validateNotEmpty(String inputBonusNumber) {
        if (StringUtils.isBlank(inputBonusNumber)) {
            throw new IllegalArgumentException(ERROR_EMPTY_BONUS_NUMBER);
        }
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
        }
    }

    private static void validateDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER);
            }
        }
    }

}
