package lotto.application.common;

import static lotto.application.common.constants.Constants.NEW_LINE;
import static lotto.application.common.constants.Constants.ZERO;

public class OutputPrinter {

    private final StringBuilder messageBuilder;

    public OutputPrinter() {
        this.messageBuilder = new StringBuilder();
    }

    public void appendWithLine(String message) {
        messageBuilder.append(message).append(NEW_LINE);
    }

    public void appendLine() {
        messageBuilder.append(NEW_LINE);
    }


    public void execute() {
        System.out.print(messageBuilder.toString());
        messageBuilder.setLength(ZERO);
    }

}
