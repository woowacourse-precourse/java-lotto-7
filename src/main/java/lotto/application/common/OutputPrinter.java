package lotto.application.common;

import static lotto.application.common.constants.Constants.ZERO;

public class OutputPrinter {

    private final StringBuilder messageBuilder;

    public OutputPrinter() {
        this.messageBuilder = new StringBuilder();
    }

    public void appendWithLine(String message) {
        messageBuilder.append(message).append('\n');
    }

    public void appendLine() {
        messageBuilder.append('\n');
    }


    public void execute() {
        System.out.print(messageBuilder.toString());
        messageBuilder.setLength(ZERO);
    }

}
