package lotto.view;

import lotto.view.formatter.ErrorFormatter;

public class ErrorView {

    private static final ErrorFormatter ERROR_FORMATTER = new ErrorFormatter();

    protected ErrorView() {
    }

    public static void announceError(Exception exception) {
        String formattedException = ERROR_FORMATTER.format(exception);
        System.out.println(formattedException + "\n");
    }
}
