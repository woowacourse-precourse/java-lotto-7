package lotto.view.error;

public class InputErrorException extends IllegalArgumentException{

    public InputErrorException(ErrorType inputError){
        super(ErrorType.ERROR_MESSAGE.getMessage()+inputError.getMessage());
    }

    public InputErrorException(String errorMessage){
        super(ErrorType.ERROR_MESSAGE.getMessage()+ errorMessage);
    }
}
