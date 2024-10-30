package lotto.enums;

public enum ErrorCause {

    PURCHASE_PRICE_CANNOT_BE_ZERO_OR_NEGATIVE("구입 금액은 0보다 커야합니다."),
    ACCESS_ATTEMPT_EXCEEDED("회 이상 실패로 앱이 종료됩니다."),
    PURCHASE_PRICE_UNIT("구입 금액은 딱 떨어지게 입력해야 합니다."),
    INPUT_VALUE("숫자를 입력해 주세요.")
    ;

    private final String message;

    ErrorCause(String message) {
        this.message = message;
    }

    public String getMessage() {
        return  message;
    }
}
