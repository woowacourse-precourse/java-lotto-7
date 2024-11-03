package lotto.model.draw;

import static lotto.constant.ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE;
import static lotto.constant.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.Set;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(final String bonusNumberInput, final DrawNumbers drawNumbers) {
        validateIsPositiveInteger(bonusNumberInput);
        bonusNumber = Integer.parseInt(bonusNumberInput);
        validateInRange(bonusNumber);
        validateNoDuplicate(bonusNumber, drawNumbers);
    }

    private void validateIsPositiveInteger(final String bonusNumber) {
        if (!bonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT.getFormatMessage());
        }
    }

    private void validateInRange(final int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT.getFormatMessage());
        }
    }

    private void validateNoDuplicate(final int bonusNumber, final DrawNumbers drawNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(drawNumbers.getDrawNumbers());
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT + 1) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE.getFormatMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
