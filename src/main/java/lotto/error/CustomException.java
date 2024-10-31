package lotto.error;

public class CustomException extends IllegalArgumentException {
    public CustomException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.toString());
    }
}
