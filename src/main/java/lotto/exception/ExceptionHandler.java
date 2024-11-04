package lotto.exception;


public class ExceptionHandler {

    private static final String HEADER_MESSAGE = "[ERROR]: ";

    private ExceptionHandler(){}

    public static void inputException(ErrorMessage errorMessage) throws IllegalArgumentException{
        System.out.println(HEADER_MESSAGE + errorMessage.getMessage());
        throw new IllegalArgumentException(errorMessage.getMessage());
    }


}
