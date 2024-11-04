package lotto.exception;

public enum ErrorMessage {
    EMPTY_PURCHASE_PRICE("[ERROR] 구매할 금액을 입력해야 합니다."),
    INVALID_PURCHASE_PRICE("[ERROR] 구입 금액은 양의 정수여야 합니다."),
    INVALID_AMOUNT_MULTIPLE("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBERS_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복될 수 없습니다."),
    EMPTY_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력해야 합니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    EMPTY_BONUS_NUMBER("[ERROR] 보너스 번호를 입력해야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}