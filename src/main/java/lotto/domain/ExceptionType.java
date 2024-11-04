package lotto.domain;

public enum ExceptionType {
  NUMBER_FORMAT("[ERROR] 정수 6개를 입력해야 합니다"),
  ILLEGAL_STATE("[ERROR] 중복된 숫자가 있는지 확인해주세요"),
  ILLEGAL_ARGUMENT("[ERROR] 로또 번호는 6개여야 합니다." ),
  OUT_OF_RANGE("[ERROR] 입력 수는 6개를 넘어서지 않아야 합니다" );

  ExceptionType(String message) {
    this.message = message;
  }

  private String message;

  public String getMessage() {
    return message;
  }
}
