package lotto.domain;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBERS;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_NOT_NUMERIC;

public class BonusNumber {

    private final int number;

    public BonusNumber(String number, WinningNumbers numbers) {
        validate(number, numbers);
        this.number = Integer.parseInt(number);
    }

    private void validate(String number, WinningNumbers numbers) {
        try {
            int bonusNumber = Integer.parseInt(number);
            Lotto.checkNumberRange(bonusNumber);
            checkDuplicatedWithWinningNumbers(bonusNumber, numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_NUMERIC);
        }
    }

    private void checkDuplicatedWithWinningNumbers(int bonusNumber, WinningNumbers numbers) {
        Lotto winningNumbers = numbers.getNumbers();
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBERS);
        }
    }

    public int getNumber() {
        return number;
    }
}
