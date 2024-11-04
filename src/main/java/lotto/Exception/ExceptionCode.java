package lotto.Exception;

public interface ExceptionCode {
    String ERROR_MESSAGE = "[ERROR]";

    String getMessage();

    default String getErrorMessage() {
        return ERROR_MESSAGE + getMessage();
    }

    default String getArgsErrorMessage(Object... args) {
        return ERROR_MESSAGE + String.format(getMessage(), args);
    }
}
