package lotto;

public class ErrorMessages {
    private static final String ERROR_SIGN = "[ERROR] ";

    public static final String INVALID_PURCHASE_AMOUNT = ERROR_SIGN + "구입 금액은 1000원 단위여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_NUMBER = ERROR_SIGN + "구입 금액은 숫자여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT = ERROR_SIGN + "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = ERROR_SIGN + "로또 번호는 중복되지 않아야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = ERROR_SIGN + "번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_COUNT = ERROR_SIGN + "당첨 번호는 6개여야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER = ERROR_SIGN + "당첨 번호는 중복되지 않아야 합니다.";
    public static final String BONUS_NUMBER_NOT_NUMBER = ERROR_SIGN + "보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = ERROR_SIGN + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}
