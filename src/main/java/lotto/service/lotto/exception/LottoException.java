package lotto.service.lotto.exception;

import lotto.common.exception.ExceptionEnum;
import lotto.common.exception.GlobalException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class LottoException extends GlobalException {

  public LottoException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum);
  }
}
