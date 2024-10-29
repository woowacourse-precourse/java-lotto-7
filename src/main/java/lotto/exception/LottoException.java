package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final LottoError lottoError;
    public LottoException(LottoError error) {
        super();
        this.lottoError = error;
    }

    @Override
    public String getMessage() {
        return String.join(" ", ERROR_MESSAGE_PREFIX, lottoError.getMessage());
    }
}
