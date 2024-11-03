package lotto.view.message;

public enum ErrorMessage {
    IS_EMPTY("빈 입력입니다."),
    NOT_NUMERIC("입력이 숫자가 아닙니다."),
    NOT_POSITIVE("입력이 양수가 아닙니다."),
    NOT_PRICE_UNITS("구입 금액이 1,000원 단위가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
