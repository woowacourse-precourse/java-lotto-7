package lotto.exception;

public enum ErrorMessage {
    EMPTY_INPUT_IS_NOT_POSSIBLE("빈 값은 입력할 수 없어요."),

    INVALID_NUMBER_FORMAT("숫자만 입력할 수 있어요."),
    INVALID_SIZE_OF_PURCHASE("0 이하는 입력할 수 없어요."),
    INVALID_PRICE_OF_PURCHASE("1,000원 단위로 구매할 수 있어요."),
    INVALID_COUNT_OF_PURCHASE("최대 100,000원까지 구매할 수 있어요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
