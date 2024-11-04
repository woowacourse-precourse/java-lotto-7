package lotto.domain;

import lotto.util.Converter;
import lotto.validation.BonusNumberValidator;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, WinningNumber winningNumber) {
        BonusNumberValidator.validateConvertBonusNumber(number, winningNumber);
        BonusNumberValidator.validateBonusNumber(Converter.convertIntToString(number));
        this.number = number;
    }

    public boolean isEqual(int myNumber) {
        return number == myNumber;
    }
}
