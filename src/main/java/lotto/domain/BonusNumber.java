package lotto.domain;

import static lotto.constants.ErrorMessage.CANT_DUPLICATED_BONUS_NUMBER_WITH_WINNING_NUMBER;
import static lotto.constants.ErrorMessage.INPUT_LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.constants.LottoConstant.END_NUMBER;
import static lotto.constants.LottoConstant.START_NUMBER;

public class BonusNumber {

    private int bonus;

    public BonusNumber(int bonus, Lotto winningNumber) {
        validate(bonus, winningNumber);
        this.bonus = bonus;
    }

    private void validate(int number, Lotto winningNumber) {
        checkNumberRange(number);
        checkNumberDuplicated(number, winningNumber);
    }

    private void checkNumberRange(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException(INPUT_LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void checkNumberDuplicated(int number, Lotto winningNumber) {
        if (winningNumber.getNumbers().contains(number)) {
            throw new IllegalArgumentException(CANT_DUPLICATED_BONUS_NUMBER_WITH_WINNING_NUMBER.getMessage());
        }
    }

    public int getBonus() {
        return bonus;
    }
}
