package lotto.exception;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 입력 값이 비었습니다."),

    NOT_NUMERIC("[ERROR] 입력된 금액이 숫자가 아닙니다."),
    NOT_POSITIVE("[ERROR] 입력된 금액은 양수여야 합니다."),
    EXCEEDS_LIMIT("[ERROR] 입력된 금액이 너무 큽니다. 최대 금액은 1억 원입니다."),
    NOT_MULTIPLE_OF_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
