package lotto.constant;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER("로또 번호는 6개여야 합니다."),
    INVALID_PURCHASE_AMOUNT_TYPE("구입 금액은 숫자여야 합니다."),
    INVALID_LOTTO_PRICE_UNIT("로또 가격은 1000원 이상이어야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45사이여야 합니다."),
    INVALID_WINNING_NUMBERS_TYPE("당첨 번호는 숫자여야 합니다."),
    INVALID_BONUS_NUMBER_TYPE("보너스 번호는 숫자여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
