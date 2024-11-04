package lotto;

public enum ErrorType {
    NOT_INTEGER("정수형만 입력 가능합니다."),
    HAS_DUPLICATE("중복된 값이 존재합니다."),
    OUT_OF_RANGE("1~45 사이의 정수만 입력 가능합니다."),
    INVALID_MONEY("입력 금액이 유효하지 않습니다."),
    NUMBER_COUNT("번호 개수는 6개여야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorType(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
