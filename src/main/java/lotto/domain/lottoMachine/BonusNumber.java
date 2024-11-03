package lotto.domain.lottoMachine;

import lotto.global.exception.Exception;
import lotto.global.exception.ValidatorBuilder;

public class BonusNumber {
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    private final int bonusNumber;

    private BonusNumber(final String bonusNumber) {
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    public static BonusNumber from(final String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public boolean isDuplicate(final int number) {
        return bonusNumber == number;
    }

    private int validateBonusNumber(final String bonusNumber) {
        return ValidatorBuilder.from(bonusNumber)
                .validateIsInteger()
                .validateInteger(number -> number < MIN_BONUS_NUMBER || number > MAX_BONUS_NUMBER,
                        Exception.INVALID_LOTTO_NUMBER)
                .getNumericValue();
    }

}
