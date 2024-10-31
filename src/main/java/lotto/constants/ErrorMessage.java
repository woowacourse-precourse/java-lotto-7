package lotto.constants;

public enum ErrorMessage {
    EMPTY_AMOUNT("로또 금액이 입력되지 않았습니다. 다시 입력해주세요."),
    NON_NUMERIC("숫자가 아닙니다. 다시 입력해주세요."),
    UNDER_MIN_AMOUNTS("로또는 1000원이상 구매가능합니다. 1000원 이상의 금액을 입력해주세요."),
    OVER_MAX_AMOUNTS("로또는 최대 10만원까지 구매가능합니다. 10만원 이하의 금액을 입력해주세요."),
    IS_NOT_DIVISIBLE_BY_THOUSAND_WON("1000원 단위로 구매가능합니다. 다시 입력해주세요."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return "[ERROR]" + message;
    }
}
