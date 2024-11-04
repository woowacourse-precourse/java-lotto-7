package lotto.exception;

public enum ErrorMessage {
    INVALID_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 있습니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않은 수여야 합니다"),
    STATISTICS_NOT_CALCULATED("[ERROR] 통계가 계산되지 않았습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}