package lotto.common.exception;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 30.
 */
public class GlobalException extends RuntimeException {
  private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
  public GlobalException (ExceptionEnum exceptionEnum) {
    this(exceptionEnum, "런타임 메시지가 없습니다.");
  }

  public GlobalException (ExceptionEnum exceptionEnum, String runtimeMessage) {
    String fullMessage = ERROR_MESSAGE_PREFIX +
        exceptionEnum.getMessage() +
        runtimeMessage;
    throw exceptionEnum.getType()
        .createException(fullMessage);
  }
}
