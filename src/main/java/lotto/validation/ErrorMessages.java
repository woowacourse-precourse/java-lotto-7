package lotto.validation;

public enum ErrorMessages {
    INVALID_CASH("[ERROR] 구입 금액은 1,000,000원 이하의 양수여야 합니다."),
    NON_NUMBER_CASH("[ERROR] 구입 금액은 숫자로 입력해야 합니다."),
    INVALID_LOTTO_FORMAT("[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다."),
    NON_NUMBER_LOTTO("[ERROR] 로또 번호는 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    NON_NUMBER_BONUS("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
