package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATION_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

public class WinningLotto {
    private static final int LOTTO_NUMBER_RANGE_MIN = 1;
    private static final int LOTTO_NUMBER_RANGE_MAX = 45;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateWinningNumberInput(winningLotto);
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
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

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
