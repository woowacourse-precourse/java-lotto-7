package lotto.controller.inputValidator;

import static lotto.exception.ErrorBase.BONUS_NUMBER_BLANK;
import static lotto.exception.ErrorBase.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorBase.BONUS_NUMBER_NON_NUMERIC;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.util.ValidationUtils.parseInteger;
import static lotto.util.ValidationUtils.validateNotBlank;

import java.util.List;
import lotto.util.ValidationUtils;

public class BonusNumberValidator {
    public static Integer validate(String bonusNumber, List<Integer> winningNumbers) {
        validateNotBlank(bonusNumber, BONUS_NUMBER_BLANK.getMessage());

        Integer parsedBonusNumber = parseInteger(bonusNumber, BONUS_NUMBER_NON_NUMERIC.getMessage());
        validateNoDuplicate(parsedBonusNumber, winningNumbers);
        validateNumberRange(parsedBonusNumber);

        return parsedBonusNumber;
    }

    private static void validateNoDuplicate(Integer bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateNumberRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

}
