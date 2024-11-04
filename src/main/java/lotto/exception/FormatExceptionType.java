package lotto.exception;

public enum FormatExceptionType implements BaseExceptionType {
    INVALID_NUMBER_FORMAT("[ERROR] 숫자 형식이 올바르지 않습니다."),
    INVALID_INPUT_FORMAT("[ERROR] 입력 형식이 올바르지 않습니다."),
    EMPTY_INPUT("[ERROR] 입력값이 비어있습니다.");

    private final String errorMessage;

    FormatExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }
}