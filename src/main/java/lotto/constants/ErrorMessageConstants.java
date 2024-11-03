package lotto.constants;

public class ErrorMessageConstants {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static final String INSTANCE_CREATION_ERROR = "Cannot instantiate this class.";

    public static final String EMPTY_PURCHASE_AMOUNT = ERROR_PREFIX + "구입 금액은 공백일 수 없습니다.";
    public static final String INVALID_NUMBER_FORMAT = ERROR_PREFIX + "구입 금액은 숫자로 입력해야 합니다.";
    public static final String INVALID_NON_POSITIVE_PURCHASE_AMOUNT = ERROR_PREFIX + "구입 금액은 양의 정수로 입력해야 합니다.";
    public static final String INVALID_LOTTO_AMOUNT_UNIT = ERROR_PREFIX + "구입 금액은 1,000원 단위로 입력해야 합니다.";

    public static final String EMPTY_WINNING_NUMBERS = ERROR_PREFIX + "로또 번호는 공백일 수 없습니다.";
    public static final String INVALID_WINNING_NUMBER_FORMAT = ERROR_PREFIX + "로또 번호는 숫자로 입력해야 합니다.";
    public static final String INVALID_WINNING_NUMBER_COUNT = ERROR_PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_RANGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자를 입력해야 합니다.";
    public static final String INVALID_WINNING_NUMBER_DUPLICATE = ERROR_PREFIX + "로또 번호는 중복될 수 없습니다.";

    public static final String EMPTY_BONUS_NUMBER = ERROR_PREFIX + "보너스 번호는 공백일 수 없습니다.";
    public static final String INVALID_BONUS_NUMBER_FORMAT = ERROR_PREFIX + "보너스 번호는 숫자로 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = ERROR_PREFIX + "보너스 번호는 1부터 45 사이의 숫자를 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_DUPLICATE = ERROR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private ErrorMessageConstants() {
        throw new IllegalStateException(INSTANCE_CREATION_ERROR);
    }
}
