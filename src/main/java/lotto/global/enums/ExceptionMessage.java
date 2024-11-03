package lotto.global.enums;

public enum ExceptionMessage {
    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] 로또 번호는 쉼표로 구분된 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("[ERROR] 로또 번호 또는 보너스 번호는 중복되지 않아야 합니다 "),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),

    INVALID_LOTTO_PRICE("[ERROR] 로또 구매 가격은 숫자여야 합니다."),
    INVALID_LOTTO_PRICE_UNIT("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다."),

    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
