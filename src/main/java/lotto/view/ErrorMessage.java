package lotto.view;

public enum ErrorMessage {
    NULL_INPUT("[ERROR] 입력값이 존재하지 않습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
