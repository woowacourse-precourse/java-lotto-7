package lotto;

public enum ErrorMessage {
    DUPLICATE_LOTTO_NUMBER("중복된 당첨 번호가 입력되었습니다."),
    INVALID_LOTTO_NUMBER_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_CONTAINS_NON_POSITIVE("[ERROR]당첨 번호는 양수만 입력 가능합니다."),
    LOTTO_NUMBER_RANGE("[ERROR]로또 번호의 숫자는 1~45까지만 허용됩니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

