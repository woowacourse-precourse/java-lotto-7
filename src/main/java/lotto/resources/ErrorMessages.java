package lotto.resources;

public enum ErrorMessages {
    // Lotto
    INVALID_LOTTO_TOTAL_NUMBER("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되면 안됩니다."),

    // Number
    SMALLER_THAN_LOTTO_MIN_NUMBER("[ERROR] 로또 번호는 1 이상이어야 합니다."),
    BIGGER_THAN_LOTTO_MAX_NUMBER("[ERROR] 로또 번호는 45 이하여야 합니다.");

    private final String message;

    ErrorMessages(final String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }

}
