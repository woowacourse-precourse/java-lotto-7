package common;

public enum ErrorMessage {
    ERROR_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요."),
    ERROR_INVALID_NUMBER_FORMAT("[ERROR] 숫자로 입력해 주세요."),
    ERROR_INVALID_WINNER_NUMBER_COUNT("[ERROR] 당첨 번호는 6개여야 합니다."),
    ERROR_NUMBER_OUT_OF_RANGE("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_DUPLICATE_LOTTO_NUMBER("[ERROR] 중복된 번호가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
