package lotto.view;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public void print(String output) {
        System.out.println(output);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage + NEW_LINE);
    }
}
