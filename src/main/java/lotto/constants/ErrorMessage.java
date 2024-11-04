package lotto.constants;

public enum ErrorMessage {
    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력 가능합니다."),

    INVALID_PURCHASE_AMOUNT_RANGE("[ERROR] 입력값이 너무 큽니다."),
    INVALID_PURCHASE_AMOUNT_ZERO("[ERROR] 구입 금액은 0보다 커야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 %d원 단위여야 합니다."),

    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 %d개여야 합니다."),
    INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),

    INVALID_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 %d개여야 합니다."),
    INVALID_WINNING_NUMBERS_RANGE("[ERROR] 당첨 번호는 %d이상 %d이하여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 당첨 번호는 중복될 수 없습니다."),

    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 %d이상 %d이하여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}
