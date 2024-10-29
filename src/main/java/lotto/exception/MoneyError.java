package lotto.exception;

public enum MoneyError {

    MUST_BE_NUMBER("금액은 숫자만 입력해야 합니다."),
    NOT_DIVISIBLE_TO_THOUSAND("금액은 1000원 단위로 입력해야 합니다."),
    ;

    private final String message;

    MoneyError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
