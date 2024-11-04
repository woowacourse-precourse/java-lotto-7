package lotto.execption;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."),
    PURCHASE_AMOUNT_NOT_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_NEGATIVE_OR_ZERO("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_WINNING_NUMBER("[ERROR] 당첨 번호는 1부터 45까지의 숫자여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_COUNT("[ERROR] 당첨 번호는 총 6개여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45까지의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
