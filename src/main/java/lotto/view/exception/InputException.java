package lotto.view.exception;

import lotto.common.exception.ExceptionEnum;
import lotto.common.exception.GlobalException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class InputException extends GlobalException {

  public InputException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum);
  }

  public InputException(ExceptionEnum exceptionEnum, String runtimeMessage) {
    super(exceptionEnum, runtimeMessage);
  }
}
