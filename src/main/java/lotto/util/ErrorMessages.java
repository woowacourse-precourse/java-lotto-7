package lotto.util;

public class ErrorMessages {

  public static final String INPUT_REQUIRED = "[ERROR] 입력이 필요합니다.";
  public static final String NUMBER_REQUIRED = "[ERROR] %s은(는) 숫자여야 합니다.";
  public static final String AMOUNT_MIN = "[ERROR] 구입 금액은 1,000원 이상이어야 합니다.";
  public static final String AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
  public static final String LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 %d개여야 합니다.";
  public static final String LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
  public static final String LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
  public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

  private ErrorMessages() {

  }
}
