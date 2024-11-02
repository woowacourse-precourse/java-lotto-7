package lotto.command.validate;

import lotto.common.exception.ExceptionEnum;
import lotto.dto.PurchaseAmountUserInput;
import lotto.dto.UserInput;
import lotto.view.exception.InputException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchaseAmountCommand implements ValidateCommand {
  private static final int AMOUNT_UNIT = 1000;
  private static final int AMOUNT_MAXIMUM = (Integer.MAX_VALUE / AMOUNT_UNIT) * AMOUNT_UNIT;
  private static final String ASK = "\n구입금액을 입력해 주세요.";

  @Override
  public UserInput execute(String input) {
    try {
      return validate(input);
    } catch (IllegalArgumentException | IllegalStateException e) {
      view.displayOutput(e.getMessage());
      return redo();
    }
  }

  private PurchaseAmountUserInput validate (String input) {
    validateBlank(input);
    validateWhiteSpace(input);
    int value = validateIntegerRange(input,
        AMOUNT_UNIT,
        AMOUNT_MAXIMUM);
    validateUnit(value);
    return PurchaseAmountUserInput.from(value);
  }

  @Override
  public String ask() {
    return ASK;
  }

  private void validateUnit(int value) {
    if (value % AMOUNT_UNIT > 0){
      throw new InputException(ExceptionEnum.PURCHASE_AMOUNT_NOT_IN_UNIT,
          String.valueOf(AMOUNT_UNIT));
    }
  }
}
