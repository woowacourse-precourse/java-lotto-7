package lotto;

public enum ErrorMessage {
    NUMERIC_VALUE_ERROR("숫자를 입력해주세요."),
    POSITIVE_AMOUNT_ERROR("구매 금액을 양수로 입력해주세요."),
    PURCHASE_AMOUNT_THOUSAND_UNIT_ERROR("구매 금액을 1000원 단위로 입력해주세요."),
    LOTTO_NUMBERS_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATION_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_RANGE_ERROR("로또 번호는 1-45 사이입니다."),
    WINNING_NUMBERS_INPUT_COMMA_ERROR("정확히 당첨 번호를 작성해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }
}
