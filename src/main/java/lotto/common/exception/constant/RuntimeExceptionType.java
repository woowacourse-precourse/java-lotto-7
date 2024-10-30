package lotto.common.exception.constant;

import lotto.common.exception.ExceptionStrategy;
import lotto.common.exception.IllegalArgumentExceptionStrategy;
import lotto.common.exception.IllegalStateExceptionStrategy;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 30.
 */
public enum RuntimeExceptionType {
  ILLEGAL_ARGUMENT(new IllegalArgumentExceptionStrategy()),
  ILLEGAL_STATE(new IllegalStateExceptionStrategy());

  private final ExceptionStrategy strategy;

  RuntimeExceptionType(ExceptionStrategy strategy) {
    this.strategy = strategy;
  }

  public RuntimeException createException(String message) {
    return this.strategy
        .createException(message);
  }
}
