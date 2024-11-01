package lotto.common.constant;

public enum ErrorMessage {

    LOTTO_SHOULD_BE_SIX("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
