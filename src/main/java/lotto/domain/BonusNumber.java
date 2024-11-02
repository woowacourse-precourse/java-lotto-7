package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.InputException;
import lotto.util.ConvertInput;

public class BonusNumber {
    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private final Lotto lotto;
    private final int bonusNumber;

    private BonusNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(Lotto lotto, String input) {
        int bonusNumber = ConvertInput.makeBonusNumberToInt(input);
        return new BonusNumber(lotto, bonusNumber);
    }

    private void validate(int bonusNumber) {
        validateRangeOfNumbers(bonusNumber);
        validateNumberInWinningNumbers(bonusNumber);
    }

    private void validateRangeOfNumbers(int bonusNumber) {
        if (isNotInValidRange(bonusNumber)) {
            throw InputException.from(ErrorMessage.BONUS_NUMBER_HAS_OUT_OF_BOUND_NUMBER);
        }
    }

    private boolean isNotInValidRange(int bonusNumber) {
        return bonusNumber < LOTTO_MINIMUM_BOUND || bonusNumber > LOTTO_MAXIMUM_BOUND;
    }

    private void validateNumberInWinningNumbers(int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw InputException.from(ErrorMessage.BONUS_NUMBER_IS_IN_LOTTO_NUMBER);
        }
    }
}
