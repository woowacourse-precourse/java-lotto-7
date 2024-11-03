package lotto.util;

import java.util.List;

public class LottoValidator {
    public static void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER.getMessage());
        }
        if (!winningNumbers.stream().allMatch(num -> num >= 1 && num <= 45) || !(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER.getMessage());
        }
    }
}