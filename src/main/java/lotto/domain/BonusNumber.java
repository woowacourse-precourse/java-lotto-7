package lotto.domain;

import lotto.util.Convertor;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String input) {
        return new BonusNumber(Convertor.convertToInt(input));
    }

    public boolean isEqualTo(int number) {
        return this.bonusNumber == number;
    }
}
