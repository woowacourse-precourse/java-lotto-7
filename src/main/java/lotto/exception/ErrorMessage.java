package lotto.exception;

public enum ErrorMessage {
    INVALID_LOTTO_COUNTS("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_DUPLICATE("로또 번호는 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private String message;

    public String getMessage() {
        return this.message;
    }

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }
}
