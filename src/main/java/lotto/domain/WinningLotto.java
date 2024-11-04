package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATE_WITH_WINNING_NUMBER;

public class WinningLotto {
    final private Lotto lotto;
    final private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateBonusNumberUnique();
    }

    private void validateBonusNumberUnique() {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_WINNING_NUMBER.getMessage());
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
