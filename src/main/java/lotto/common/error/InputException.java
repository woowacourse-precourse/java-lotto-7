package lotto.common.error;

import lotto.common.AppErrorType;

public class InputException extends IllegalArgumentException {
    private final AppErrorType inputError;

    public InputException(AppErrorType inputError) {
        this.inputError = inputError;
    }

    @Override
    public String getMessage() {
        return inputError.getMessage();
    }
}