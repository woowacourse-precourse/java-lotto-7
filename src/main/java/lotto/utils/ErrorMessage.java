package lotto.utils;

public class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String PURCHASE_AMOUNT_NOT_NUMBER = "구입 금액은 숫자여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND = "구입 금액은 1,000원 단위여야 합니다.";
    public static final String LOTTO_NUMBER_COUNT_INVALID = "로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATED = "로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_NOT_NUMBER = "로또 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_NOT_NUMBER = "보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_OUT_OF_RANGE = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATED = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String WINNING_NUMBER_COUNT_INVALID = "당첨 번호는 6개여야 합니다.";
    public static final String PURCHASE_AMOUNT_INVALID = "구입 금액은 1,000원 이상의 양수여야 합니다.";
}
