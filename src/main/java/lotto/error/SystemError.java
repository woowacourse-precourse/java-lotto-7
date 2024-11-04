package lotto.error;

import lotto.error.format.ErrorMessageFormat;

public enum SystemError {

    MAX_RETRY_EXCEEDED("너무 많은 입력으로 기본값 %s을/를 입력합니다.");

    private final String message;
    private final String prefix = ErrorMessageFormat.PREFIX.getMessage();

    SystemError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
