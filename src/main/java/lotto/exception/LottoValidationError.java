package lotto.exception;

public enum LottoValidationError {

    INVALID_LOTTO_NUMBERS_COUNT("로또 번호는 %d 개여야 합니다."),
    LOTTO_NUMBER_ABOVE_MAXIMUM("로또 번호는 %d 이하의 숫자여야 합니다."),
    LOTTO_NUMBER_BELOW_MINIMUM("로또 번호는 %d 이상의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS_EXISTS("로또 번호에 중복된 숫자가 존재합니다."),
    BONUS_NUMBER_ABOVE_MAXIMUM("보너스 번호는 %d 이하의 숫자여야 합니다."),
    BONUS_NUMBER_BELOW_MINIMUM("보너스 번호는 %d 이상의 숫자여야 합니다."),
    LOTTO_NUMBERS_CONTAINS_BONUS_NUMBER("로또 번호에 보너스 번호가 포함될 수 없습니다."),

    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 %d원 단위여야 합니다."),
    PURCHASE_AMOUNT_ABOVE_MAXIMUM("구입 금액은 최대 %d 원 이하여야 합니다."),
    PURCHASE_AMOUNT_BELOW_MINIMUM("구입 금액은 최소 %d 원 이상이여야 합니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    LottoValidationError(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public void throwException(Object... args) {
        throw new LottoException(getMessage(args));
    }

    private String getMessage(Object... args) {
        return String.format(message, args);
    }
}
