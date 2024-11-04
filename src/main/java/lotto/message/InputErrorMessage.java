package lotto.message;

public enum InputErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다."),
    EMPTY_PURCHASE_AMOUNT("[ERROR] 구입 금액을 입력해 주세요."),
    NON_NUMERIC_PURCHASE_AMOUNT("[ERROR] 구입 금액은 양수여야 하며, int 범위를 초과할 수 없습니다."),
    INVALID_WINNING_NUMBER_COUNT("[ERROR] 당첨 번호는 중복 없이 6개의 숫자여야 합니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NULL_WINNING_NUMBER("[ERROR] 당첨 번호를 비울 수 없습니다."),
    NON_NUMERIC_WINNING_NUMBER("[ERROR] 당첨 번호는 양수여야 하며, int 범위를 초과할 수 없습니다."),
    NON_NUMERIC_BONUS_NUMBER("[ERROR] 보너스 번호는 양수여야 하며, int 범위를 초과할 수 없습니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복 입력이 불가능합니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
