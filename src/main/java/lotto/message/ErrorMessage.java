package lotto.message;

public enum ErrorMessage {
    EMPTY_INPUT_ERROR_MESSAGE("구입 금액으로 빈 문자열을 입력할 수 없습니다. 다시 시도해 주세요."),
    NOT_POSITIVE_INTEGER_INPUT_MESSAGE("구입 금액은 양의 정수만 입력할 수 있습니다. 다시 시도해 주세요."),
    NOT_INTEGER_RANGE_INPUT_MESSAGE("구입 금액은 정수형 범위의 숫자만 입력할 수 있습니다. 다시 시도해 주세요."),
    INVALID_UNIT_ERROR_MESSAGE("구입 금액은 반드시 천원 단위로 떨어져야 합니다. 다시 입력해 주세요."),
    UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE("한번 구매할때 10만원 이하로 구매할 수 있습니다. 다시 시도해 주세요."),
    INVALID_NUMBER_COUNT_ERROR_MESSAGE("로또 번호는 6개여야 합니다. 다시 입력해 주세요."),
    DUPLICATED_NUMBER_ERROR_MESSAGE("로또 숫자는 중복될 수 없습니다. 다시 입력해 주세요."),
    INVALID_NUMBER_RANGE_ERROR_MESSAGE("로또 숫자는 1 부터 45 까지 입력할 수 있습니다. 다시 입력해 주세요."),

    EMPTY_INPUT_WINNING_NUMBERS_ERROR_MESSAGE("당첨 번호를 입력할 때 빈 문자열을 입력할 수 없습니다. 다시 시도해 주세요."),
    INVALID_CONTENT_WINNING_NUMBERS_ERROR_MESSAGE("당첨 번호를 입력할 때 숫자와 콤마만 입력할 수 있습니다. 다시 시도해 주세요."),
    CHAINED_COMMA_WINNING_NUMBERS_ERROR_MESSAGE("당첨 번호를 입력할 때 콤마를 연속적으로 입력할 수 없습니다. 다시 시도해 주세요.");

    ;

    private final String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
