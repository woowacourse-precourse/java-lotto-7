package lotto.enums;

public enum ErrorMessage {
    INVALID_AMOUNT("금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_WINNING_NUMBERS("당첨 번호는 6개여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private static final String ERROR_TAG = "[ERROR]";
    private static final String ERROR_SEPARATOR = " ";  // 태그 뒤 공백
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG + ERROR_SEPARATOR + message;
    }

    public String format(Object... args) {
        return ERROR_TAG + ERROR_SEPARATOR + String.format(message, args);
    }
}
