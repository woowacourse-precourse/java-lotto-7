package lotto.io.printer.error;

import lotto.io.printer.StringPrinter;

public class ConsoleErrorPrinter implements ErrorPrinter {

    private final StringPrinter stringPrinter;

    public ConsoleErrorPrinter(StringPrinter stringPrinter) {
        this.stringPrinter = stringPrinter;
    }

    @Override
    public void printErrorMessage(Exception exception) {
        stringPrinter.printString(exception.getMessage());
    }
}
