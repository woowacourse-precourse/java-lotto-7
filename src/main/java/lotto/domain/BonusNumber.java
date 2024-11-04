package lotto.domain;

import lotto.util.ErrorMessages;
import lotto.util.LottoNumberValidator;

public class BonusNumber {

  private final int number;

  public BonusNumber(int number, WinningNumber winningNumber) {
    LottoNumberValidator.validateNumber(number);
    validateNotDuplicate(number, winningNumber);
    this.number = number;
  }

  private void validateNotDuplicate(int number, WinningNumber winningNumber) {
    if (winningNumber.contains(number)) {
      throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE);
    }
  }

  public int getNumber() {
    return number;
  }
}
