package lotto.exception;

public class LottoApplicationException extends IllegalArgumentException {

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    public LottoApplicationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return MESSAGE_PREFIX + super.getMessage();
    }

}
