package lotto.global.message;

public class ErrorMessage {
    private static final String ERROR_PREFIX = "[ERROR] ";

    // Money 관련 에러 메시지
    public static final String MINIMUM_PURCHASE_AMOUNT = ERROR_PREFIX + "로또 구매는 1000원부터 가능합니다.";
    public static final String INVALID_PURCHASE_UNIT = ERROR_PREFIX + "로또 구매는 1000원 단위로 가능합니다";

    // 입력 검증 관련 에러 메시지
    public static final String EMPTY_INPUT = ERROR_PREFIX + "입력값이 없습니다.";
    public static final String INVALID_NUMBER_FORMAT = ERROR_PREFIX + "유효한 숫자 형식이 아닙니다.";
    public static final String NEGATIVE_NUMBER = ERROR_PREFIX + "금액은 음수가 될 수 없습니다.";
    public static final String COMMA_SEPARATED_NUMBER = ERROR_PREFIX + "쉼표(,)로 구분된 숫자만 입력 가능합니다.";

    // Lotto 관련 에러 메시지
    public static final String INVALID_LOTTO_SIZE = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = ERROR_PREFIX + "당첨 번호에 중복된 숫자가 있습니다.";

    // BonusNumber 관련 에러 메시지
    public static final String INVALID_BONUS_NUMBER_RANGE = ERROR_PREFIX + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}