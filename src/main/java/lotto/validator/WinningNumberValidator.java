package lotto.validator;

import java.util.List;

import static lotto.constants.Constants.*;
import static lotto.constants.ErrorStringConstants.*;

public class WinningNumberValidator {

    public void validateWinningNumber(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < LOTTO_STARTING_RANGE.getValue() || winningNumber > LOTTO_END_RANGE.getValue()) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE.getValue());
            }
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_STARTING_RANGE.getValue() || bonusNumber > LOTTO_END_RANGE.getValue()) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE.getValue());
        }
    }

    public void validateNotDuplication(List<Integer> winningNumbers, int bonusNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE.getValue());
            }
        }
    }
}
