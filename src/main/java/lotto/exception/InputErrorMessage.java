package lotto.exception;

public enum InputErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    EMPTY_PURCHASE_AMOUNT("[ERROR] 구입 금액은 비어있을 수 없습니다."),
    NEGATIVE_OR_ZERO_AMOUNT("[ERROR] 구입 금액은 0원 이상이어야 합니다."),
    EXCEEDS_LIMIT_AMOUNT("[ERROR] 구입 금액은 1,000,000원을 초과할 수 없습니다."),
    INVALID_NUMERIC_AMOUNT("[ERROR] 구입 금액은 숫자여야 합니다."),

    EMPTY_WINNING_NUMBERS("[ERROR] 당첨 번호는 비어있을 수 없습니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호는 숫자여야 합니다."),
    NEGATIVE_OR_ZERO_WINNING_NUMBER("[ERROR] 당첨 번호는 1~45 범위의 양의 정수여야 합니다."),
    DUPLICATED_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복될 수 없습니다."),

    EMPTY_BONUS_NUMBER("[ERROR] 보너스 번호는 비어있을 수 없습니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    NEGATIVE_OR_ZERO_BONUS_NUMBER("[ERROR] 보너스 번호는 1~45 범위의 양의 정수여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");


    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
