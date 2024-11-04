package lotto.status;

public enum ErrorMessages {
    HAS_DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 있습니다."),
    IS_OUT_OF_LOTTO_NUMBER("[ERROR] 로또 번호는 1 ~ 45 까지 입력 가능합니다."),
    INVALID_LUCKY_NUMBERS_COUNT("[ERROR] 당첨 번호 6개를 입력해 주세요."),
    MAX_PURCHASE_LIMIT("[ERROR] 로또는 최대 10만원 까지만 구매할 수 있습니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 있습니다."),
    EMPTY_VALUE("[ERROR] 아무것도 입력하지 않았습니다."),
    NON_POSITIVE_NUMERIC("[ERROR] 음수는 입력할 수 없습니다."),
    NON_NUMERIC("[ERROR] 정수만 입력해 주세요."),
    INVALID_FORMAT("[ERROR] 입력형식이 옳바르지 않습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
