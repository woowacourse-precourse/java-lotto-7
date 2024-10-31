package lotto.view;

public class OutView {
    public static final String ERROR_MESSAGE = "[ERROR]";

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + " : " + errorMessage);
    }
}
