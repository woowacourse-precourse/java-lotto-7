package lotto.message;

public enum ErrorMessage {
    EMPTY_INPUT_ERROR_MESSAGE("구입 금액으로 빈 문자열을 입력할 수 없습니다. 다시 시도해 주세요."),
    NOT_POSITIVE_INTEGER_INPUT_MESSAGE("구입 금액은 양의 정수만 입력할 수 있습니다. 다시 시도해 주세요."),
    NOT_INTEGER_RANGE_INPUT_MESSAGE("구입 금액은 정수형 범위의 숫자만 입력할 수 있습니다. 다시 시도해 주세요.");
    ;

    private final String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
