package lotto.validation;

import java.util.HashSet;
import java.util.List;
import lotto.constants.RandomNumberConstants;
import lotto.enums.ErrorMessage;

public class WinningAndBonusNumbersValidator {
    private static final int QUANTITY_OF_WINNING_NUMBERS = 7;

    public static void validateWinningAndBonusNumbers(List<Integer> winningAndBonusNumbers) {
        validateNumbers(winningAndBonusNumbers);
        validateDuplicate(winningAndBonusNumbers);
    }

    private static void validateNumbers(List<Integer> winningAndBonusNumbers) {
        if (winningAndBonusNumbers.size() != QUANTITY_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_WINNING_NUMBERS_QUANTITY.getMessage());
        }
        for (Integer number : winningAndBonusNumbers) {
            if (number < RandomNumberConstants.MINIMUM_RANDOM_NUMBER
                || number > RandomNumberConstants.MAXIMUM_RANDOM_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
            }
        }
    }

    private static void validateDuplicate(List<Integer> winningAndBonusNumbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
          for (Integer number : winningAndBonusNumbers) {
              if (!uniqueNumbers.add(number)) {
                  throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
              }
        }
    }
}
