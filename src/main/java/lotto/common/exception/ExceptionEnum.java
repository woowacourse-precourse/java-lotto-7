package lotto.common.exception;

import lotto.common.exception.constant.RuntimeExceptionType;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 30.
 */
public enum ExceptionEnum {
  IVALID_INPUT(RuntimeExceptionType.ILLEGAL_ARGUMENT, "잘못된 입력입니다."),
  INVALID_STATE(RuntimeExceptionType.ILLEGAL_STATE, "잘못된 상태입니다.");

  private final RuntimeExceptionType type;
  private final String message;

  ExceptionEnum(RuntimeExceptionType type, String message) {
    this.type = type;
    this.message = message;
  }

  public RuntimeExceptionType getType() {
    return type;
  }

  public String getMessage() {
    return this.message;
  }
}
