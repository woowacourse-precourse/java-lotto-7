package lotto.constants;

public class ErrorMessageConstants {

    public static final String INSTANCE_CREATION_ERROR = "Cannot instantiate this class.";

    public static final String EMPTY_PURCHASE_AMOUNT = "구입 금액은 공백일 수 없습니다.";
    public static final String INVALID_NUMBER_FORMAT = "구입 금액은 숫자로 입력해야 합니다.";
    public static final String INVALID_NON_POSITIVE_PURCHASE_AMOUNT = "구입 금액은 양의 정수로 입력해야 합니다.";
    public static final String INVALID_LOTTO_AMOUNT_UNIT = "구입 금액은 1,000원 단위로 입력해야 합니다.";

    public static final String EMPTY_WINNING_NUMBERS = "로또 번호는 공백일 수 없습니다.";
    public static final String INVALID_WINNING_NUMBER_FORMAT = "로또 번호는 숫자로 입력해야 합니다.";
    public static final String INVALID_WINNING_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자를 입력해야 합니다.";
    public static final String INVALID_WINNING_NUMBER_DUPLICATE = "로또 번호는 중복될 수 없습니다.";

    public static final String EMPTY_BONUS_NUMBER = "보너스 번호는 공백일 수 없습니다.";
    public static final String INVALID_BONUS_NUMBER_FORMAT = "보너스 번호는 숫자로 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = "보너스 번호는 1부터 45 사이의 숫자를 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_DUPLICATE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private ErrorMessageConstants() {
        throw new IllegalStateException(INSTANCE_CREATION_ERROR);
    }
}
