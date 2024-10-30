package lotto.config;

public enum ErrorMessage {
    INPUT_MONEY_ERROR("숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] ".concat(message);
    }
}
