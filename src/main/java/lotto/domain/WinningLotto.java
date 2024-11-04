package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATION_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

public class WinningLotto {
    private static final int LOTTO_NUMBER_RANGE_MIN = 1;
    private static final int LOTTO_NUMBER_RANGE_MAX = 45;

    private final Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto) {
        validateWinningNumberInput(winningLotto);
        this.winningNumbers = winningLotto;
    }

    private void validateWinningNumberInput(Lotto winningLotto) {
        for (int number : winningLotto.getNumbers()) {
            validateNumberRange(number);
        }
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        validateNumberRange(bonusNumber);

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
