package lotto.exception;

public class MoneyException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final MoneyError moneyError;
    public MoneyException(MoneyError error) {
        super();
        this.moneyError = error;
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + this.moneyError.getMessage();
    }
}
