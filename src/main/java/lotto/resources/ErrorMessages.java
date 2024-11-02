package lotto.resources;

public enum ErrorMessages {
    // Money
    NEGATIVE_QUANTITY_MONEY("[ERROR] 돈은 0원 이상이어야 합니다."),
    INVALID_THOUSAND_UNIT_MONEY("[ERROR] 돈은 1,000원 단위로 떨어져야 합니다."),
    // Lotto
    INVALID_LOTTO_TOTAL_NUMBER("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되면 안됩니다."),

    // Number
    INVALID_RANGE_LOTTO_NUMBER("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.");

    private final String message;

    ErrorMessages(final String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }

}
