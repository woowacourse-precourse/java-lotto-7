package lotto.error;

public enum ErrorStatus {
    NULL_OR_EMPTY_INPUT("[ERROR] 입력값은 null이거나 빈 문자열일 수 없습니다."),
    INVALID_NEGATIVE_NUMBER("[ERROR] 음수는 입력할 수 없습니다."),
    INVALID_MONEY_AMOUNT("[ERROR] 로또 금액은 1000원 단위여야 합니다."),
    INVALID_INPUT_INTEGER("[ERROR] 입력값은 정수여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 입력값에 중복된 숫자가 있습니다: "),
    INVALID_NUMBER_SIZE("[ERROR] 로또 번호는 6개여야 합니다.");
    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
