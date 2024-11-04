package lotto.exception;

public class LottoException {

  private static final String ERROR_INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
  private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
  private static final String ERROR_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";
  private static final String ERROR_OUT_OF_RANGE_BONUS = "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.";
  private static final String ERROR_DUPLICATE_BONUS = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
  private static final String ERROR_INVALID_FORMAT = "[ERROR] 입력 값은 숫자로 입력해 주세요.";
  private static final String ERROR_INVALID_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

  public static void throwInvalidSizeException() {
    throw new IllegalArgumentException(ERROR_INVALID_SIZE);
  }

  public static void throwDuplicateNumberException() {
    throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
  }

  public static void throwOutOfRangeException() {
    throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
  }

  public static void throwOutOfRangeBonusException() {
    throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_BONUS);
  }

  public static void throwDuplicateBonusException() {
    throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
  }

  public static IllegalArgumentException throwInvalidFormatException() {
    return new IllegalArgumentException(ERROR_INVALID_FORMAT);
  }

  public static void throwInvalidPurchaseAmountException() {
    throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
  }
}
