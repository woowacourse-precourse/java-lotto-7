package lotto.service;

import lotto.constants.ErrorMessages;

import java.util.List;

public class BonusNumber {
    private final Integer bonus;
    private final WinningNumber winningNumber;

    public BonusNumber(Integer bonus, WinningNumber winningNumber) {
        this.bonus = bonus;
        this.winningNumber = winningNumber;
        validateBonus();
    }

    private void validateBonus() {
        validateNull(bonus);
        validateRange(bonus);
        validateNoDuplicateWithWinningNumbers(bonus,winningNumber.getNumbers());
    }

    private void validateNoDuplicateWithWinningNumbers(Integer bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE_WITH_WINNING_NUMBER);
        }
    }

    private void validateRange(Integer bonus) {
        if(bonus <1|| bonus >45){
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateNull(Integer bonus) {
        if(bonus ==null){
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_REQUIRED);
        }
    }

    public Integer getBonus() {
        return bonus;
    }
}
