package validators;

import static content.ErrorMessage.BONUS_AND_WINNING_NUMBERS_DUPLICATION;
import static content.ErrorMessage.EMPTY_WINNING_NUMBERS;
import static content.ErrorMessage.WINNING_NUMBERS_DUPLICATION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_WINNING_NUMBERS.getMessage());
        }
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATION.getMessage() + winningNumbers);
        }
        if (uniqueNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_AND_WINNING_NUMBERS_DUPLICATION.getMessage());
        }
    }
}
