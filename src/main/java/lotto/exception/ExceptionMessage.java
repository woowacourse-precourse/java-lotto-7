package lotto.exception;

public enum ExceptionMessage {
    EMPTY_INPUT("[ERROR] 아무것도 입력되지 않았습니다."),
    INVALID_INPUT("[ERROR] 잘못된 입력 형식입니다. 양의 정수만 입력할 수 있습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 1부터 45 사이여야 합니다."),

    MAX_PURCHASE_AMOUNT_EXCEEDED("[ERROR] 구입 금액은 100,000원을 초과할 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),

    WINNING_NUMBER_DUPLICATE("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다."),
    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),

    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}