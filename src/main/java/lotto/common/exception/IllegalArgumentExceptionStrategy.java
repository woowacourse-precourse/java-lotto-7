package lotto.common.exception;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class IllegalArgumentExceptionStrategy implements ExceptionStrategy {

  @Override
  public RuntimeException createException(String message) {
    return new IllegalArgumentException(message);
  }
}
