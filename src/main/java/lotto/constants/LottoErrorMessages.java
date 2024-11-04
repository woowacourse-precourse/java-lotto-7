package lotto.constants;

public class LottoErrorMessages {

  public static final String ERROR_PREFIX = "[ERROR] ";

  public static final String INVALID_PURCHASE_AMOUNT = ERROR_PREFIX + "유효하지 않은 금액입니다. 다시 입력해주세요.";
  public static final String INVALID_WINNING_NUMBER = ERROR_PREFIX + "유효하지 않은 당첨 번호입니다.";
  public static final String INVALID_BONUS_NUMBER = ERROR_PREFIX + "유효하지 않은 보너스 번호입니다.";
  public static final String INVALID_NUMBER_FORMAT = ERROR_PREFIX + "구입 금액은 숫자로 입력해야 합니다.";
  public static final String INVALID_BONUS_NUMBER_FORMAT = ERROR_PREFIX + "보너스 번호는 숫자로 입력해야 합니다.";
  public static final String INVALID_PURCHASE_AMOUNT_FORMAT =
      ERROR_PREFIX + "구입 금액은 " + LottoConstants.LOTTO_PRICE + "원 단위로 입력해야 합니다.";
  public static final String INVALID_WINNING_NUMBER_RANGE =
      ERROR_PREFIX + "당첨 번호는 " + LottoConstants.MIN_NUMBER + "~" + LottoConstants.MAX_NUMBER
          + " 사이의 숫자 6개여야 합니다.";
  public static final String INVALID_BONUS_NUMBER_RANGE =
      ERROR_PREFIX + "보너스 번호는 " + LottoConstants.MIN_NUMBER + "~" + LottoConstants.MAX_NUMBER
          + " 사이 숫자 중 당첨 번호와 중복되지 않는 숫자여야 합니다.";

  private LottoErrorMessages() {
    // 인스턴스화 방지
  }
}
