package lotto.view;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String inputMoney() {
        outputView.printMessage(Output.INPUT_MONEY);
        return inputView.userInput();
    }
}
