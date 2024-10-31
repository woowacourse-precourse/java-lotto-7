package lotto.validation;

import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;

public class WinningNumbersValidator {
  public static void mainValidator(List<Integer> winningAndBonusNumbers) {
    validateNumbers(winningAndBonusNumbers);
    validateDuplicate(winningAndBonusNumbers);
  }

  private static void validateNumbers(List<Integer> winningAndBonusNumbers) {
    for (Integer number : winningAndBonusNumbers) {
      if (number <= 0 || number > 45) {
        throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
      }
    }
  }

  private static void validateDuplicate(List<Integer> winningAndBonusNumbers) {
    HashSet<Integer> uniqueNumbers = new HashSet<>();
    for (Integer number : winningAndBonusNumbers) {
      if (!uniqueNumbers.add(number)) {
        throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
      }
    }
  }
}
