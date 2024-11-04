package lotto.ui;

public class ConsoleOutputUi implements OutputUi {
    @Override
    public void print(final String message) {
        System.out.print(message);
    }

    @Override
    public void printWithLineBreak(final String message) {
        System.out.println(message);
    }
}
