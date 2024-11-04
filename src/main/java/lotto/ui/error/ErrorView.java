package lotto.exception;

public class ErrorView {
    private final static String ERROR = "[ERROR] ";


    public void printError(String message) {
        System.out.println(ERROR + message);
    }

}
