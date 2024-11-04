package lotto.command.view.validate;

import static lotto.service.lotto.constant.LottoConstant.MATCH_SIX_PRIZE;

import lotto.common.exception.ExceptionEnum;
import lotto.dto.PurchaseAmountUserInput;
import lotto.dto.UserInput;
import lotto.service.lotto.constant.LottoConstant;
import lotto.view.exception.InputException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class PurchaseAmountCommand implements ValidateCommand {
  private static final long AMOUNT_MAXIMUM = (Long.MAX_VALUE / MATCH_SIX_PRIZE) * LottoConstant.AMOUNT_UNIT;
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

  public PurchaseAmountUserInput validate (String input) {
    validateBlank(input);
    validateWhiteSpace(input);
    long value = validateLongRange(input,
        LottoConstant.AMOUNT_UNIT,
        AMOUNT_MAXIMUM);
    validateUnit(value);
    return PurchaseAmountUserInput.from(value);
  }

  @Override
  public String ask() {
    return ASK;
  }

  private void validateUnit(long value) {
    if (value % LottoConstant.AMOUNT_UNIT > 0){
      throw new InputException(ExceptionEnum.PURCHASE_AMOUNT_NOT_IN_UNIT,
          String.valueOf(LottoConstant.AMOUNT_UNIT));
    }
  }
}
