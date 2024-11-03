package lotto.Common;

public enum ErrorMessage {

    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자를 입력해야 합니다."),
    INVALID_WINNING_NUMBER_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
