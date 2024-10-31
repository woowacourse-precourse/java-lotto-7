package lotto.domain;

public enum ExceptionType {
  NUMBER_FORMAT, ILLEGAL_STATE, ILLEGAL_ARGUMENT, OUT_OF_RANGE;

  private String message;

  public String getMessage() {
    return message;
  }
}
