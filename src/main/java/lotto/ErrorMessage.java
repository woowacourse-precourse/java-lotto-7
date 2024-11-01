package lotto;

public enum ErrorMessage {
    NOT_A_NUMBER("숫자를 입력해야 합니다."),
    OUT_OF_RANGE("%d ~ %d 사이의 숫자만 입력할 수 있습니다."),
    INVALID_DELIMITER("'%s'를 사용하여 숫자를 구분해야 합니다."),

    INVALID_SIZE_LOTTO("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_MONEY("로또는 1000원 단위로 구입해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
