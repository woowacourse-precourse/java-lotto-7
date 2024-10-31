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

    public String inputWinningLotto() {
        outputView.printMessage(Output.INPUT_WINNING_NUMBER);
        return inputView.userInput();
    }

    public String inputBonusNumber() {
        outputView.printMessage(Output.INPUT_BONUS_NUMBER);
        return inputView.userInput();
    }
}
