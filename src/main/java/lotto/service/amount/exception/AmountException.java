package lotto.service.amount.exception;

import lotto.common.exception.ExceptionEnum;
import lotto.common.exception.GlobalException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class AmountException extends GlobalException {

  public AmountException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum);
  }
}
