package lotto.domain;

import lotto.common.ErrorMessage;

public class BonusNumber {
    private static final Integer MININUM_NUMBER = 1;
    private static final Integer MAXIM1UM_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {

        validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber<MININUM_NUMBER || bonusNumber>MAXIM1UM_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }
}
