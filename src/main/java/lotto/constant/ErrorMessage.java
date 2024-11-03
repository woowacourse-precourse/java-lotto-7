package lotto.constant;

public enum ErrorMessage {
    NULL_INPUT_ERROR("[ERROR] Null이 입력되었습니다."),
    EMPTY_INPUT_ERROR("[ERROR] 입력된 값이 없습니다."),
    NUMBER_COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    PRICE_INPUT_ERROR("[ERROR] 로또의 구매 금액은 1,000으로 나누어 떨어져야합니다."),
    DUPLICATION_ERROR("[ERROR] 중복된 값이 입력되었습니다."),
    NUMBER_RANGE_ERROR("[ERROR] 2,147,483,647 이하의 양수를 입력해주세요."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다."),
    STACK_OVERFLOW_ERROR_MESSAGE("[ERROR] 올바른 값을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
