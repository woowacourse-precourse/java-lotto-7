package lotto.message;

public enum ErrorMessage {

    INVALID_MONEY_TYPE("[ERROR] 금액은 1000원 단위의 숫자로 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
