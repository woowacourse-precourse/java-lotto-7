package lotto.validation;

import lotto.enums.ErrorMessage;

public class MoneyValidator {
    private static final int MONEY_UNIT = 1000;
    private static final int MINIMUM_AMOUNT = 0;
    private static final int DIVISIBILITY_CHECK = 0;

  public static void validateMoney(Integer money) {
    if (money <= MINIMUM_AMOUNT) {
      throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
    }
    if (money % MONEY_UNIT != DIVISIBILITY_CHECK) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT.getMessage());
    }
  }
}
