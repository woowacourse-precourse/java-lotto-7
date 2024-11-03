package lotto.view;

public final class OutputView {
    private static String NEW_LINE = "\n";

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
