package lotto.validator;

import java.util.List;
import lotto.exception.LottoException;

public class BonusNumberValidator {

  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;

  public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
    if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
      LottoException.throwOutOfRangeBonusException();
    }
    if (winningNumbers.contains(bonusNumber)) {
      LottoException.throwDuplicateBonusException();
    }
  }
}
