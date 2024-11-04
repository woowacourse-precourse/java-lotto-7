package lotto.model;

public enum ErrorMessage {

    INVALID_WINNING_NUMBER("[ERROR] 올바른 당첨번호 입력 형식이 아닙니다"),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 당첨 숫자는 당첨 숫자와 같으면 안됩니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_ATTEMPT_COUNT("[ERROR] 시도 횟수는 0보다 커야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 양수만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 숫자는 1 ~ 45 까지 입력해주세요."),
    MINIMUM_PURCHASE_AMOUNT("[ERROR] 로또 금액은 1000원 이상이어야 합니다."),
    INVALID_PURCHASE_UNIT("[ERROR] 로또 금액은 1000원 단위여야 합니다."),
    DUPLICATE_WINNING_NUMBERS("[ERROR] 로또 번호는 중복되면 안됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}