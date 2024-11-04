package lotto.view;

import lotto.exception.ExceptionCode;

public class ErrorPrinter {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printError(String message) {
        System.out.print(ERROR_PREFIX + message + "\n");
    }
}
