package lotto;

public enum ExceptionMessages {
    INVALID_AMOUNT("[ERROR] 올바른 형식의 입력금액이 아닙니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
