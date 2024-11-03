package lotto.application.ticket.view.output;

public class OutputPrinter {

    private final StringBuilder messageBuilder;

    public OutputPrinter() {
        this.messageBuilder = new StringBuilder();
    }

    public void appendLine(String message) {
        messageBuilder.append(message).append('\n');
    }

    public void execute() {
        System.out.print(messageBuilder.toString());
        messageBuilder.setLength(0);
    }

}
