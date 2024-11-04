package lotto.message.error;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 로또 구매는 1,000원 단위만 가능합니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 로또 번호는 1에서 45사이의 값만 입력이 가능합니다."),
    INVALID_WINNING_NUMBERS_CNT("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
