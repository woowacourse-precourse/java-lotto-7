package lotto.exception;

public enum ExceptionMessage {

    BLANK_INPUT_EXCEPTION("빈 문자열은 입력할 수 없습니다."),
    NONE_NUMERIC_INPUT_EXCEPTION("숫자 값만 입력할 수 있습니다."),
    INVALID_LOTTO_AMOUNT_EXCEPTION("로또 구입 금액은 1,000원 단위로 입력 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
