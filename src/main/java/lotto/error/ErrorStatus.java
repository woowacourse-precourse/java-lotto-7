package lotto.error;

public enum ErrorStatus {
    INVALID_INPUT_INTEGER("[ERROR] 입력값은 정수여야 합니다.");
    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
