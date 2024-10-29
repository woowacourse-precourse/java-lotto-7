package lotto.view;

public class OutputView {

    private static final String ERROR = "[Error] ";

    public void printErrorMessage(final String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }
}
