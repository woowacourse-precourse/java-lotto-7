package lotto.enums;

public enum ErrorMessage {
    // 에러 메시지
    INVALID_LOTTO_COUNT("[ERROR] 로또 구입 금액은 1000으로 나누어 떨어지는 숫자여야 합니다."),
    INVALID_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_DELIMITER("[ERROR] 구분자는 쉼표(,)여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
