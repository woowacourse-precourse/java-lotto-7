package lotto.Exception;

public class MoneyException extends IllegalArgumentException {
    public MoneyException(MoneyExceptionType messageType) {
        super(messageType.getMessage());
    }
}
