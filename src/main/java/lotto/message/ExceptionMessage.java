package lotto.message;

public enum ExceptionMessage {

    INVALID_AMOUNT_TYPE("[ERROR] 금액은 숫자만 입력 가능합니다."),
    INVALID_AMOUNT_MIN("[ERROR] 금액은 최소 1000원 이상이어야 합니다."),
    INVALID_AMOUNT_DIVISION("[ERROR] 금액은 1000원으로 나눠떨어져야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}