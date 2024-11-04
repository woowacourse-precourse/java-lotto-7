package lotto.exception;

public class LottoArgumentException extends IllegalArgumentException {
    private static final String COMMON_MESSAGE = "[ERROR] ";

    public LottoArgumentException(LottoErrorMessage errorMessage) {
        super(COMMON_MESSAGE + errorMessage.getError());
    }
}
