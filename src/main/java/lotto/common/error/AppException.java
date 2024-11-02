package lotto.common.error;

public class AppException extends IllegalArgumentException {
    private final AppErrorType inputError;

    public AppException(AppErrorType inputError) {
        this.inputError = inputError;
    }

    @Override
    public String getMessage() {
        return inputError.getMessage();
    }
}