package lotto.exception;

public enum ErrorCode {

    NOT_POSITIVE_INTEGER("구매 금액은 양수만 입력 가능합니다."),
    NOT_DIVISIBLE_BY_THOUSAND("구매 금액은 천 단위의 양수만 입력 가능합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
