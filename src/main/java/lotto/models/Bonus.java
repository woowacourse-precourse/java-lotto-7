package lotto.models;

import java.util.List;

import static lotto.utils.Constants.LOTTO_LOWER_BOUND;
import static lotto.utils.Constants.LOTTO_UPPER_BOUND;
import static lotto.utils.ErrorMessages.*;
import static lotto.utils.MessageFormatter.formatErrorMessage;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto lotto) {
        validate(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto lotto) {
        List<Integer> winningNumbers = lotto.getNumbers();
        if (bonusNumber < LOTTO_LOWER_BOUND || bonusNumber > LOTTO_UPPER_BOUND) {
            throw new IllegalArgumentException(formatErrorMessage(BONUS_SHOULD + BE_IN_RANGE, LOTTO_LOWER_BOUND, LOTTO_UPPER_BOUND));
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(formatErrorMessage(BONUS_SHOULD, NOT_BE_REPEATED));
        }
    }

    public int getNumber() {
        return bonusNumber;
    }
}
