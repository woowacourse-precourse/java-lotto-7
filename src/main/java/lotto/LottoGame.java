package lotto;

public class LottoGame {
    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        inputView.displayLottoPurchaseAmountPrompt();
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();
        Lottos lottos = Lottos.from(lottoMachine.issue(lottoPurchaseAmount));
    }
}
