package lotto;

public class LottoGame {
    private final InputView inputView;

    public LottoGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.displayLottoPurchaseAmountPrompt();
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();
    }
}
