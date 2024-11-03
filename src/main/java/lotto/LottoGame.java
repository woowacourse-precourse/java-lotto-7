package lotto;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        inputView.displayLottoPurchaseAmountPrompt();
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();
        Lottos lottos = Lottos.from(lottoMachine.issue(lottoPurchaseAmount));
        outputView.displayLottoCount(lottos);
        outputView.displayLottoNumbers(lottos);
    }
}
