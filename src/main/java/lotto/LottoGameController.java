package lotto;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        inputView.displayLottoPurchaseAmountPrompt();
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();
        Lottos lottos = Lottos.from(lottoGenerator.issue(lottoPurchaseAmount));
        outputView.displayLottoCount(lottos);
        outputView.displayLottoNumbers(lottos);
    }
}
