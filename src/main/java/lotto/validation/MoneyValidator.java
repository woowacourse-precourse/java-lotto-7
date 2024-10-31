package lotto.validation;

import lotto.enums.ErrorMessage;

public class MoneyValidator {
  public static void validateMoney(Integer money) {
    if (money <= 0) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_TURN_NUMBER.getMessage());
    }
    if (money % 1000 != 0) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
    }
  }
}
