package lotto.exception;

public class IllegalRangeException extends IllegalArgumentException{

    public IllegalRangeException(){
        super(ExceptionMessage.LOTTO_NUMBER_RANGE_EXCEPTION.getMessage());
    }
}
