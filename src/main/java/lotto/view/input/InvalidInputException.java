package lotto.view.input;

public class InvalidInputException extends IllegalArgumentException{
    public InvalidInputException(InputError inputError){
        super(inputError.message);
    }
}
