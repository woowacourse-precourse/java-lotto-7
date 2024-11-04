package lotto.enums;

public enum ErrorMessage {
    // 에러 메시지
    INVALID_LOTTO_COUNT("[ERROR] 로또 구입 금액은 1000으로 나누어 떨어지는 숫자여야 합니다."),
    INVALID_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LENGTH("[ERROR] 로또는 6자리의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("[ERROR] 로또 번호는 중복되지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
