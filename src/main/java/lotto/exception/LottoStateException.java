package lotto.exception;

public class LottoStateException extends IllegalStateException {
    private static final String COMMON_MESSAGE = "[ERROR] ";

    public LottoStateException(LottoErrorMessage errorMessage) {
        super(COMMON_MESSAGE + errorMessage.getError());
    }
}