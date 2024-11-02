package lotto.exception;

public class IllegalPriceNumberException extends IllegalArgumentException {

    public IllegalPriceNumberException() {
        super(ExceptionMessage.PRICE_NUMBER_EXCEPTION.getMessage());
    }
}
