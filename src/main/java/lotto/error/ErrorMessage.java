package lotto.error;

public enum ErrorMessage {
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 입력 값은 숫자 형태여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호가 당첨 번호에 중복되었습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 번호 입력 값 범위가 올바르지 않습니다."),
    AMOUNT_OUT_OF_RANGE("[ERROR] 금액 입력 값 범위가 올바르지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
