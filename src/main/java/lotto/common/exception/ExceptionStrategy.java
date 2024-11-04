package lotto.common.exception;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 30.
 */
public interface ExceptionStrategy {
  RuntimeException createException(String type);
}
