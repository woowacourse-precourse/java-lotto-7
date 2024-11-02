package lotto.common;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 입력이 비어있습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
