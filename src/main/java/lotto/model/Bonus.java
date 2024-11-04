package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATE_WINNING_AND_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constant.GameValue.MAX_LOTTO_NUMBER;
import static lotto.constant.GameValue.MIN_LOTTO_NUMBER;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLottoNumbers) {
        validate(bonusNumber, winningLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningLottoNumbers) {
        validateRange(bonusNumber);
        validateDuplicateWithWinningLottoNumbers(bonusNumber, winningLottoNumbers);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER.getValue() || bonusNumber > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateWithWinningLottoNumbers(int bonusNumber, Lotto winningLottoNumbers) {
        if (winningLottoNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_AND_BONUS_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
