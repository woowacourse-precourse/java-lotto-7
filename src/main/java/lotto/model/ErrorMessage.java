package lotto.model;


public enum ErrorMessage {
    PURCHASE_AMOUNT_UNIT("구입 금액은 %d원 단위여야 합니다."),
    MIN_PURCHASE_AMOUNT("구입 금액은 %d원 보다 커야 합니다."),
    NUMBER_COUNT("당첨 번호는 %d개의 숫자여야 합니다."),
    NUMBER_RANGE("당첨 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("당첨 번호는 중복되지 않는 숫자여야 합니다."),
    NUMBER_FORMAT("당첨 번호는 숫자여야 합니다."),
    BONUS_NUMBER_RANGE("보너스 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_FORMAT("보너스 번호는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }
}


