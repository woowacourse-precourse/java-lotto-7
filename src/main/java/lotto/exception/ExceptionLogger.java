package lotto.exception;

import lotto.basic.StringPrinter;

public class ExceptionLogger {
    private final ExceptionFormatter formatter;
    private final StringPrinter printer;

    public ExceptionLogger(ExceptionFormatter formatter, StringPrinter printer) {
        this.formatter = formatter;
        this.printer = printer;
    }

    public void log(RuntimeException exception) {
        printer.print(formatter.format(exception));
    }
}
