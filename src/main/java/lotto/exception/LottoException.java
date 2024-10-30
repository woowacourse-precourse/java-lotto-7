package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";

    public LottoException(ErrorCode errorCode) {
        super(PREFIX_ERROR_MESSAGE + errorCode.getMessage());
    }
}
