package lotto.controller;

public class ExceptionController {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printException(Exception e){
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
 }
