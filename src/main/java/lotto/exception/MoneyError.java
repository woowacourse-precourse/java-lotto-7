package lotto.exception;

public enum MoneyError {

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
