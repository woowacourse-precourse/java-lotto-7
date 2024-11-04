package lotto.exception;

public enum InputError implements ApplicationError {

    INVALID_FORMAT("잘못된 형식입니다."),
    NOT_ALLOW_EMPTY("빈 값을 입력할 수 없습니다."),
    ;

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
