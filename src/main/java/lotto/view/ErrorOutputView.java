package lotto.view;

public class ErrorOutputView {

    private static final String ERROR_PREFIX = "[ERROR]";

    public static void printErrorMessage(String error) {
        System.out.println(ERROR_PREFIX + error);
    }
}
