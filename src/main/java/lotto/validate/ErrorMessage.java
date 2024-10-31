package lotto.validate;

public enum ErrorMessage {

    PURCHASE_TYPE("구입 금액은 양의 정수여야 합니다."),
    PURCHASE_UNIT("구입 금액은 1000원 단위여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
