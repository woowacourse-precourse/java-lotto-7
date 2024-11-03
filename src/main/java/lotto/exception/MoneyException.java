package lotto.exception;

public class MoneyException extends IllegalArgumentException {
    public MoneyException(ErrorMessages errorMessages) {
        super(errorMessages.getMessage());
    }
}
