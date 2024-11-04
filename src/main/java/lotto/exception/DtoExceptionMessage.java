package lotto.exception;

public enum DtoExceptionMessage implements ExceptionMessage {
    NULL_EXCEPTION("null 값이 입력되었습니다."),
    ;

    private final String message;

    DtoExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
