package lotto.ui.exception;

public enum InputExceptionMessage {

    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력할 수 있습니다.");

    private final String errorMessage;

    InputExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
