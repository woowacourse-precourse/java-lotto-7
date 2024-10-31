package lotto.common;

public enum ErrorMessage {

    INPUT_MONEY_IS_DIGIT("[ERROR] 구입 금액은 양수입니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
