package lotto;

public enum ErrorMessage {
    NOT_A_NUMBER("숫자를 입력해야 합니다."),
    OUT_OF_RANGE("%d ~ %d 사이의 숫자만 입력할 수 있습니다."),
    INVALID_DELIMITER("'%s'를 사용하여 숫자를 구분해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
