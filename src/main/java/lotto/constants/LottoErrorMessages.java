package lotto.constants;

public enum LottoErrorMessages {

  INVALID_LOTTO_NUMBER("유효하지 않은 로또 번호입니다."),
  INVALID_PURCHASE_AMOUNT("유효하지 않은 금액입니다."),
  INVALID_WINNING_NUMBER("유효하지 않은 당첨 번호입니다."),
  INVALID_BONUS_NUMBER("유효하지 않은 보너스 번호입니다.");

  private static final String ERROR_PREFIX = "[ERROR] ";
  private final String message;

  LottoErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return ERROR_PREFIX + message;
  }
}
