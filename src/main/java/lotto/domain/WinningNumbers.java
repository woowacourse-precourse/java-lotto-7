package lotto.domain;

import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;

public class WinningNumbers {

    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto numbers, int bonusNumber) {
        this.lotto = numbers;
        validateBonusNumber(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, Lotto numbers) {
        List<Integer> winningNumbers = numbers.getNumbers();
        if (bonusNumber < LOTTO_NUM_MIN || bonusNumber > LOTTO_NUM_MAX) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}