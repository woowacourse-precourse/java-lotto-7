package lotto.common;

public enum Error {
    LOTTO_LENGTH_LIMIT("로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_INTEGER_NUMBER(Integer.MAX_VALUE + "까지의 숫자를 입력해주세요."),
    NOT_DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_MONEY("금액은 천원 단위로 입력할 수 있습니다.");

    private final String message;

    Error(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
