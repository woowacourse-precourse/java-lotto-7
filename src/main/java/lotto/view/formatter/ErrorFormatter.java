package lotto.view.formatter;

public class ErrorFormatter {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public ErrorFormatter() {
    }

    public String format(Exception exception) {
        return ERROR_MESSAGE_PREFIX + exception.getMessage();
    }
}
