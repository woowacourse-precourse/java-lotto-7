package lotto.exception;

public class ExceptionMessages {
    public static final String LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATION_ERROR = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    public static final String INVALID_NUMBER_FORMAT_ERROR = "[ERROR] 숫자 형식만 입력 가능합니다. 잘못된 형식: ";
    public static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 잘못된 번호: ";
    public static final String LOTTO_BUY_AMOUNT_UNIT_ERROR = "[ERROR] 구매 금액은 1,000 단위여야 합니다.";
    public static final String BONUS_LOTTO_NUMBER_IN_LOTTO_NUMBERS_ERROR = "[ERROR] 보너스 번호랑 로또 번호는 중복 불가합니다.";
}
