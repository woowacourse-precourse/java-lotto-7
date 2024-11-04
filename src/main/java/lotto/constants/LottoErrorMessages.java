package lotto.constants;

public class LottoErrorMessages {

  public static final String ERROR_PREFIX = "[ERROR] ";
  public static final String INVALID_LOTTO_NUMBER= ERROR_PREFIX + "유효하지 않은 로또 번호입니다.";
  public static final String INVALID_PURCHASE_AMOUNT = ERROR_PREFIX + "유효하지 않은 금액입니다.";
  public static final String INVALID_WINNING_NUMBER = ERROR_PREFIX + "유효하지 않은 당첨 번호입니다.";
  public static final String INVALID_BONUS_NUMBER = ERROR_PREFIX + "유효하지 않은 보너스 번호입니다.";

  private LottoErrorMessages() {
    // 인스턴스화 방지
  }
}
