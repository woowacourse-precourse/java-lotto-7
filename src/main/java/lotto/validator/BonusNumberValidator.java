package lotto.validator;

import java.util.List;

public class BonusNumberValidator {

  private static final String ERROR_OUT_OF_RANGE_BONUS = "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.";
  private static final String ERROR_DUPLICATE_BONUS = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

  public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
    if (bonusNumber < 1 || bonusNumber > 45) {
      throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_BONUS);
    }
    if (winningNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
    }
  }
}
