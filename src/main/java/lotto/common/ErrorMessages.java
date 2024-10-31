package lotto.common;

public class ErrorMessages {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static final String LOTTO_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_DUPLICATE_MESSAGE = "[ERROR] 로또 번호에 중복이 있을 수 없습니다.";
    public static final String LOTTO_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";

    public static final String NULL_PURCHASE_AMOUNT = "구입 금액을 입력해야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_UNIT = "구입 금액은 1,000원 단위여야 합니다.";
    public static final String EXCEEDED_PURCHASE_AMOUNT = "구입 금액은 100,000원을 초과할 수 없습니다.";
    public static final String INVALID_PURCHASE_AMOUNT_INPUT_ERROR = "입력 값 중 유효하지 않은 숫자가 포함되어 있습니다. 소수나 문자는 허용되지 않습니다.";

    public static final String NULL_WINNING_NUMBER = "당첨 번호를 입력해야 합니다.";
    public static final String INVALID_WINNING_NUMBER_COUNT = "당첨 번호는 쉼표로 구분된 6개 번호여야 합니다.";
    public static final String INVALID_NUMBER_RANGE = "당첨 번호는 1부터 45 사이여야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER = "당첨 번호는 중복 없이 6개여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_INPUT_ERROR = "입력 값 중 유효하지 않은 숫자가 포함되어 있습니다. 당첨 번호는 1부터 45 사이의 정수 6개여야 하며, 소수나 문자는 허용되지 않습니다.";

    public static final String NULL_BONUS_NUMBER = "보너스 번호를 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = "보너스 번호는 1부터 45 사이여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String INVALID_BONUS_NUMBER_INPUT_ERROR = "입력 값 중 유효하지 않은 숫자가 포함되어 있습니다. 보너스 번호는 1부터 45 사이의 정수 6개여야 하며, 소수나 문자는 허용되지 않습니다.";
}
