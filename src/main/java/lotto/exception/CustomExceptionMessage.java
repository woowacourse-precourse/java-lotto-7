package lotto.exception;

public class CustomExceptionMessage extends IllegalArgumentException{
    public CustomExceptionMessage(String message) {
        super(message);
    }
}
