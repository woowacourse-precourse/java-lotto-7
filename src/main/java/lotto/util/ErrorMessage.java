package lotto.util;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 입력이 잘못되었습니다."),
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
