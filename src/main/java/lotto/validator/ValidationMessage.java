package lotto.validator;

public enum ValidationMessage {
    INVALID_INPUT_FORMAT("로또 구입금액은 숫자로 입력되어야 합니다."),
    INVALID_NEGATIVE_PRICE("로또 구입금액은 양의 정수가 입력되어야 합니다."),
    INVALID_PURCHASE_PRICE("로또 구입금액은 1,000원으로 나누어 떨어져야 합니다.");

    private final String message;

    ValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
