package exception;

public enum ErrorMessage {

    PURCHASE_AMOUNT_INVALID_UNIT_MSG("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    NOT_NUMBER_FORMAT("[ERROR] 숫자로 입력해야 합니다."),
    DUPLICATE_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복되지 않는 숫자여야 합니다."),
    NOT_SIX_WINNING_NUMBERS("[ERROR] 당첨 번호는 6자리여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
