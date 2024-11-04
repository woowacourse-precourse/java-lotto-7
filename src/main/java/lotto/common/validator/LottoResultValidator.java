package lotto.common.validator;

import static lotto.common.ExceptionMessage.INVALID_DUPLICATE_LOTTO_NUMBER;
import static lotto.common.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.List;
import lotto.common.LottoConfig;

public class LottoResultValidator {
    public static void bonusNumberValidate(int bonusNumber, List<Integer> winningNumbers) {
        if (isBonusNumberRangeValid(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (isLottoNumberDuplicated(bonusNumber, winningNumbers)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean isBonusNumberRangeValid(int bonusNumber) {
        return !(bonusNumber >= LottoConfig.LOTTO_MIN_NUMBER.getValue()
                && bonusNumber <= LottoConfig.LOTTO_MAX_NUMBER.getValue());
    }

    private static boolean isLottoNumberDuplicated(int bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }
}
