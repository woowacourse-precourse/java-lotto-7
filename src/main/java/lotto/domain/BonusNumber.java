package lotto.domain;

import lotto.util.Constants;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if(bonusNumber< Constants.MIN_LOTTO_NUMBER || bonusNumber > Constants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
