package lotto.enums;

public class ErrorMessage implements SystemMessage {
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
