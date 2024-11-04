package lotto.common.exception;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 30.
 */
public class IllegalStateExceptionStrategy implements ExceptionStrategy {

  @Override
  public RuntimeException createException(String message) {
    return new IllegalStateException(message);
  }
}
