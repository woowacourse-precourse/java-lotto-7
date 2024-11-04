package lotto.controller.inputValidator;

import static lotto.exception.ErrorBase.BONUS_NUMBER_BLANK;
import static lotto.exception.ErrorBase.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorBase.BONUS_NUMBER_NON_NUMERIC;
import static lotto.util.CommonValidator.validateNumberRange;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.util.CommonValidator.parseInteger;
import static lotto.util.CommonValidator.validateNotBlank;

import java.util.List;

public class BonusNumberValidator {
    public static Integer validate(String bonusNumber, List<Integer> winningNumbers) {
        validateNotBlank(bonusNumber, BONUS_NUMBER_BLANK.getMessage());
        Integer parsedBonusNumber = parseInteger(bonusNumber, BONUS_NUMBER_NON_NUMERIC.getMessage());
        validateNoDuplicate(parsedBonusNumber, winningNumbers);
        validateNumberRange(List.of(parsedBonusNumber), LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
        return parsedBonusNumber;
    }

    private static void validateNoDuplicate(Integer bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
