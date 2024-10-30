package lotto.exception;

public enum Exception {
    INVALID_LOTTO_NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
