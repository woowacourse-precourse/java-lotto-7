package lotto.validate;

import static lotto.constants.Constants.*;

public class BonusNumberValidate {

    private final int bonusNumber;

    public BonusNumberValidate(String number) {
        int bonusNumber = parseBonusNumber(number);
        isRangeNumber(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private int parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + BONUS_NUMBER_MUST_NUMBER);
        }
    }

    private void isRangeNumber(int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ERROR + BONUS_NUMBER_RANGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
