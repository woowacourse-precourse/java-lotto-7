package lotto;

public class LottoException extends RuntimeException{
    private final String errorCode;
    private final String errorMessage;

    public LottoException(String errorCode, String errorMessage) {
        super(getExceptionMessage(errorMessage));
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private static String getExceptionMessage(String errorMessage) {
        return "[ERROR] " + errorMessage;
    }
}
