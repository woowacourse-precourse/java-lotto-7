package lotto.util;

public enum ErrorMessage {

    // 로또 구입 금액 관련 에러 메시지
    INVALID_AMOUNT_BLANK("로또 구입 금액을 입력해야 해요."),
    INVALID_AMOUNT_FORMAT("로또 구입 금액은 숫자여야 해요."),
    INVALID_AMOUNT_NATURAL_NUMBER("로또 구입 금액은 0보다 커야 해요."),
    INVALID_AMOUNT_MIN("로또 구입 금액은 최소 1,000원이어야 해요."),
    INVALID_AMOUNT_UNIT("로또 구입 금액은 1,000원 단위여야 해요."),

    // 당첨 번호 관련 에러 메시지
    INVALID_WINNING_LOTTO_BLANK("당첨 번호을 입력해야 해요."),
    INVALID_WINNING_LOTTO_SEPARATOR("당첨 번호의 구분자는 쉼표(,)여야 해요."),
    INVALID_WINNING_LOTTO_FORMAT("당첨 번호는 숫자여야 해요."),
    INVALID_WINNING_LOTTO_NATURAL_NUMBER("당첨 번호는 자연수여야 해요."),
    INVALID_WINNING_LOTTO_RANGE("당첨 번호는 1~45 사이의 수여야 해요."),
    INVALID_WINNING_LOTTO_COUNT("당첨 번호의 개수는 6개여야 해요."),
    DUPLICATE_WINNING_LOTTO("당첨 번호는 중복되지 않아야 해요."),
    INVALID_WINNING_NUMBER_EMPTY("당첨 번호에는 빈 값이 포함될 수 없어요.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}