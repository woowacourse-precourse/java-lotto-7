package lotto;

public enum ErrorMessage {
    INVALID_INPUT_MESSAGE("[ERROR] 구입 금액은 1000 이상의 숫자여야 합니다."),
    INVALID_CASH_MESSAGE("[ERROR] 구입 금액은 1000원 단위여야 합니다.")
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
