package lotto.model;

import lotto.enumerate.ExceptionEnum;
import lotto.utility.ExceptionThrower;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final int REQUIRED_NUMBERS_LENGTH = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers);
        validateDuplicates(winningNumbers);
        validateOverFourtySix(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateDuplicates(List<Integer> parsedNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(parsedNumbers);
        if (uniqueNumbers.size() != parsedNumbers.size()) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_DRAW_DUPLICATE_NUMBER);
        }
    }

    private static void validateLength(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != REQUIRED_NUMBERS_LENGTH) {
            ExceptionThrower.throwing(ExceptionEnum.MUST_SIX);
        }
    }

    private void validateOverFourtySix(List<Integer> parsedNumbers) {
        if (parsedNumbers.stream().anyMatch(number -> number > MAX_LOTTO_NUMBER)) {
            ExceptionThrower.throwing(ExceptionEnum.CANNOT_OVER_FOURTY_SIX);
        }
    }

    public void checkBonusDuplicate(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            ExceptionThrower.throwing(ExceptionEnum.DUPLICATE_WINNING_AND_BONUS);
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
