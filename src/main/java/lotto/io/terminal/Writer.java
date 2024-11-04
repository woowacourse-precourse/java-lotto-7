package lotto.io.terminal;

import java.util.List;

public class Writer {

    private Writer() {
    }

    public static Writer initiate() {
        return new Writer();
    }

    public void printErrorMessage(final String error) {
        simplePrint(error);
    }

    public void simplePrint(final String message) {
        System.out.println(message);
    }

    public void printWithNewLineBefore(final String message) {
        printEmptyLine();
        simplePrint(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printMatchingResults(final List<String> matchingResults) {
        for (String matchingResult : matchingResults) {
            simplePrint(matchingResult);
        }
    }
}
