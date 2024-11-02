package lotto.exception;

public enum InputParserExceptionMessage implements ExceptionMessage {
    NUMBER_ONLY("숫자만 입력 가능합니다. (혹은 정수 범위 초과"),
    AT_LEAST_ONE_NUMBER("최소 하나의 숫자는 입력해야 합니다."),
    NULL_OR_BLANK("입력값이 null이거나 빈 문자열입니다.");

    private final String message;

    InputParserExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
