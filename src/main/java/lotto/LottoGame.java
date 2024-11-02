package lotto;

public class LottoGame {
    private final InputView inputView;

    public LottoGame(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();
    }
}
