package lotto.exception.message;

public enum ParserExceptionMessage{
    EMPTY_INPUT("입력되지 않았습니다."),
    NOT_NUMBER("숫자를 입력해주세요");
    private final String message;

    ParserExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}