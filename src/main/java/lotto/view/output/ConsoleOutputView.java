package lotto.view.output;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printError(String message) {
        System.out.println(message + "\n");
    }
}
