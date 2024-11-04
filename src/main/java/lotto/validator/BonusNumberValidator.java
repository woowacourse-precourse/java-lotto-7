package lotto.validator;

import static lotto.constant.ErrorCode.*;
import static lotto.constant.LottoConfig.*;

import lotto.domain.Lotto;

public class BonusNumberValidator {
    private BonusNumberValidator() {
    }

    public static void isNumeric(String bonusNumber) {
        try {
            int bonus = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public static void validateNumberRange(String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        if (bonus < MIN_NUMBER.getValue() || bonus > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(OUT_OF_RANGE_BONUS_NUMBER.getMessage());
        }

    }

    public static void checkBonusNumberDuplicate(String bonusNumber, Lotto winningNumbers) {
        int bonus = Integer.parseInt(bonusNumber);
        if (winningNumbers.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
