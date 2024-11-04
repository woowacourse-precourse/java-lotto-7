package lotto.view;

public class ConsoleView {
    private final InputView inputView;
    private final OutputView outputView;

    private ConsoleView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static class ConsoleViewHolder {
        private static final ConsoleView CONSOLE_VIEW = new ConsoleView(InputView.getInstance(), OutputView.getInstance());
    }

    public static ConsoleView getInstance() {
        return ConsoleViewHolder.CONSOLE_VIEW;
    }
}
