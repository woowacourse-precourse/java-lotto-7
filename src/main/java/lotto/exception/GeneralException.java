package lotto.exception;

public class GeneralException extends IllegalArgumentException {
    private BaseErrorCode errorCode;

    public GeneralException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorCode.getErrorStatus();
    }
}
