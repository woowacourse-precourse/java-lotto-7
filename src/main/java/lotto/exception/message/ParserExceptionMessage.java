package lotto.exception.message;

public enum ParserExceptionMessage{
    EMPTY_INPUT("입력되지 않았습니다."),
    NOT_NUMBER("양의 정수를 입력해주세요."),
    NUMBER_OUT_OF_RANGE("숫자는 최대 2,147,483,647까지 가능합니다");
    private final String message;

    ParserExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}