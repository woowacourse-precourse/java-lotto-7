package lotto.common;

public enum ErrorMessage {

    INPUT_MONEY_IS_DIGIT("[ERROR] 구입 금액은 양수입니다."),
    LOTTO_NUMBERS_MUST_SIX("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
