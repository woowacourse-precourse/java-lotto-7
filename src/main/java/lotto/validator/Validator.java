package lotto.validator;

public class Validator {
    public static final String ERROR_MESSAGE = "[ERROR]";


    public static void throwInvalidInputException(String message) {

        throw new IllegalArgumentException(ERROR_MESSAGE + message);
    }
}
