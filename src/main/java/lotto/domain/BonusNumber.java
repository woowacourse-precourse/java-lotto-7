package lotto.domain;

import lotto.util.Convertor;
import lotto.validation.BonusNumberValidator;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        BonusNumberValidator.validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String input, WinningNumber winningNumber) {
        int bonusNumber = Convertor.convertToInt(input);
        BonusNumberValidator.validateUniqueBonusNumber(winningNumber, input);
        return new BonusNumber(bonusNumber);
    }

    public boolean isEqualTo(int number) {
        return this.bonusNumber == number;
    }

}
