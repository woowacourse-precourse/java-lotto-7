package lotto.utils;

public class ExceptionFactory{

    static final String OUTPUT_MESSAGE_HEAD = "[ERROR] ";

    public static void throwIllegalArgumentException(ExceptionType exceptionType) throws IllegalArgumentException{
        printExceptionMessage(exceptionType);
        throw new IllegalArgumentException( exceptionType.getMessage());
    }

    protected static void printExceptionMessage(ExceptionType exceptionType){
        String outputMessage = ExceptionFactory.OUTPUT_MESSAGE_HEAD + exceptionType.getMessage();
        System.out.println(outputMessage);
    }
}