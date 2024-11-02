package lotto;

public enum ExceptionMessages {
    INVALID_INPUT("[ERROR] 올바른 형식의 입력이 아닙니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
