package lotto.constant;

public class ErrorMessages {
    public static final String ERROR_NON_INTEGER_AMOUNT = "[ERROR] 구입금액은 정수여야 합니다.";
    public static final String ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
    public static final String ERROR_PURCHASE_AMOUNT_GREATER_THAN_ZERO = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    public static final String ERROR_NON_INTEGER_LOTTO_NUMBER = "[ERROR] 로또 번호는 정수여야 합니다.";
    public static final String ERROR_INVALID_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
    public static final String ERROR_WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_WINNING_NUMBER = "[ERROR] 당첨 번호는 중복되지 않아야 합니다.";
    public static final String ERROR_NON_INTEGER_BONUS_NUMBER = "[ERROR] 보너스 번호는 정수여야 합니다.";
    public static final String ERROR_BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String ERROR_DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String ERROR_INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";

    private ErrorMessages() {
        // 인스턴스 생성 방지
    }
}
