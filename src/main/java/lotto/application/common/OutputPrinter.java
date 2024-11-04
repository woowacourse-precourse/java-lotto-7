package lotto.application.common;

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
        messageBuilder.setLength(0);
    }

}
