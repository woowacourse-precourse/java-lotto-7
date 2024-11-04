package message;

public enum ErrorMessage {
    DUPLICATE_LOTTO_NUMBER("중복된 당첨 번호가 입력되었습니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또 당첨 번호는 6개여야 합니다."),
    LOTTO_CONTAINS_NON_POSITIVE("로또 번호는 양수만 입력 가능합니다."),
    LOTTO_NUMBER_RANGE("로또 번호의 숫자는 1~45까지만 허용됩니다."),
    INPUT_IS_EMPTY("공백이 입력으로 들어왔습니다."),
    PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND("구입금액은 1,000원 단위로 나누어 떨어져야만 합니다."),
    PURCHASE_AMOUNT_INPUT_NOT_NUMBER("구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_NOT_POSITIVE_NUMBER("구입 금액은 양수여야 합니다."),
    WINNING_NUMBER_NOT_NUMBER("당첨 번호는 숫자여야 합니다."),
    WINNING_NUMBER_NOT_POSITIVE_NUMBER("당첨 번호는 양수여야 합니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return "[ERROR]" + errorMessage;
    }
}

