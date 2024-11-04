package lotto.util;

public enum ErrorMessage {

    INVALID_AMOUNT_BLANK("로또 구입 금액을 입력해야 해요."),
    INVALID_AMOUNT_FORMAT("로또 구입 금액은 숫자여야 해요."),
    INVALID_AMOUNT_NATURAL_NUMBER("로또 구입 금액은 0보다 커야 해요."),
    INVALID_AMOUNT_MIN("로또 구입 금액은 최소 1,000원이어야 해요."),
    INVALID_AMOUNT_UNIT("로또 구입 금액은 1,000원 단위여야 해요.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}