package lotto.constant;

public enum ExceptionMessage {
    INPUT_EMPTY_STRING("빈 값은 입력할 수 없습니다."),
    INPUT_NON_DIGIT_CHARACTER("구분자 또는 숫자(0-9)만 입력할 수 있습니다."),
    INPUT_INVALID_INTEGER_RANGE("정수 범위의 값만 입력할 수 있습니다."),

    PURCHASE_PRICE_NON_POSITIVE_AMOUNT("구입 금액은 양의 정수만 가능합니다."),
    PURCHASE_PRICE_INVALID_AMOUNT_UNIT("구입 금액은 1000원 단위만 가능합니다."),

    LOTTO_NUMBERS_INVALID_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_INVALID_RANGE("로또 번호는 1~45 사이 정수만 가능합니다."),

    BONUS_NUMBER_INVALID_RANGE("보너스 번호는 1~45 사이 정수만 가능합니다."),
    BONUS_NUMBER_DUPLICATED_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + this.message;
    }
}
