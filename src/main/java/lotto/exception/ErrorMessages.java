package lotto.exception;

public class ErrorMessages {
    public static final String COST_POSITIVE_INTEGER_ERROR = "[ERROR] 금액은 양의 정수여야 합니다.";
    public static final String DIVISIBLE_BY_THOUSAND_COST_ERROR = "[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String LOTTO_NUMBER_LENGTH_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1에서 45 사이의 수여야 합니다.";
    public static final String LOTTO_NUMBER_NOT_INTEGER_ERROR = "[ERROR] 로또 번호는 숫자여야 합니다.";
    public static final String INPUT_EMPTY_ERROR = "[ERROR] 입력값은 공백이 될 수 없습니다.";
    public static final String DUPLICATE_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}
