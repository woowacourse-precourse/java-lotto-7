package lotto.exception;

public class IllegalPriceDivideException extends IllegalArgumentException {

    public IllegalPriceDivideException() {
        super(ExceptionMessage.PRICE_DIVIDE_EXCEPTION.getMessage());
    }
}
