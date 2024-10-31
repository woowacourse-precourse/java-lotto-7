package lotto.exception;

public class MoneyException extends ApplicationException {

    public MoneyException(MoneyError error) {
        super(error);
    }

}
