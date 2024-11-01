package lotto.error;

public enum LottoError {
    INVALID_PRICE_AMOUNT("[ERROR] 구입 금액은 1000 단위여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 구매 금액은 숫자여야 합니다."),
    INVALID_PRICE("[ERROR] 금액은 1000 이상이어야 합니다."),
    INVALID_PRICE_FORMAT("[ERROR] 구매 금액은 숫자여야 합니다."),
    INVALID_PRICE_RANGE("[ERROR] 구입 금액은 1000 이상이어야 합니다."),
    INVALID_PRICE_UNIT("[ERROR] 구입 금액은 1000 단위여야 합니다."),
    INVALID_WINNING_NUMBERS_DELIMITER("[ERROR] 당첨 번호 입력 시 구분자는 쉼표여야 합니다."),
    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호 개수는 6개여야 합니다."),
    INVALID_WINNING_NUMBERS_FORMAT("[ERROR] 당첨 번호는 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 하나여야 합니다."),
    INVALID_BONUS_NUMBER2("[ERROR] 보너스 번호는 숫자여야 합니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER("[ERROR] 당첨 번호는 유효한 숫자여야 합니다.");


    private final String message;

    LottoError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
