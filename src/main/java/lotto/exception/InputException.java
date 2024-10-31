package lotto.exception;

public class InputException extends ApplicationException {

    public InputException(InputError error) {
        super(error);
    }

}
