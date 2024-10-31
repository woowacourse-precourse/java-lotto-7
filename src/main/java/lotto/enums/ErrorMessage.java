package lotto.enums;

public enum ErrorMessage implements SystemMessage {
  INVALID_INT_NUMBER("숫자가 아닌 것이 입력 되었습니다."),
  INVALID_MONEY_UNIT("구입 금액은 1000원 단위로 한정됩니다."),
  INVALID_TURN_NUMBER("자연수가 아닌 숫자입니다.");

  private final String ERROR_LOG_LEVEL = "[ERROR] ";
  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return ERROR_LOG_LEVEL + message;
  }
}
