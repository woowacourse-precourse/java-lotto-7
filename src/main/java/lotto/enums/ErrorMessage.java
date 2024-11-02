package lotto.enums;

public enum ErrorMessage implements SystemMessage {
  INVALID_INT_NUMBER("숫자가 아닌 것이 입력 되었습니다. 다시 시도해주세요."),
  NOT_NATURAL_NUMBER("자연수가 아닌 숫자입니다. 다시 시도해주세요."),
  INVALID_MONEY_UNIT("구입 금액은 1000원 단위로 한정됩니다. 다시 시도해주세요."),
  INVALID_WINNING_NUMBER("보너스 번호를 포함한 당첨 번호는 1부터 45 사이의 숫자여야 합니다. 다시 시도해주세요."),
  DUPLICATE_WINNING_NUMBER("보너스 번호를 포함한 당첨 번호 중에 중복이 있습니다. 다시 시도해주세요."),
  INVALID_WINNING_NUMBERS_QUANTITY("보너스 번호는 1개, 당첨 번호는 6개여야 합니다. 다시 시도해주세요."),
  INVALID_LOTTO_QUANTITY("로또 번호는 6개여야 합니다. 다시 발행하겠습니다."),
  DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 있습니다. 다시 발행하겠습니다."),
  INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다. 다시 발행하겠습니다."),
  INVALID_CALCULATE("계산 과정에서 예상치 못한 오류가 발생했습니다.");


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
