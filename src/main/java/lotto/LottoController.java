package lotto;

public class LottoController {
    private final InputHandler inputHandler;
    private final View view;
    private final LottoService lottoService;

    public LottoController(InputHandler inputHandler, LottoService lottoService, View view) {
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
        this.view = view;
    }

    public void run() {
        LottoPurchase lottoPurchase = purchaseLotto();
        WinningNumbers winningNumbers = issueWinningNumbers();
        Lottos lottos = generateLottos(lottoPurchase);
        displayLottos(lottoPurchase, lottos);
        displayResults(lottos, winningNumbers, lottoPurchase);
    }

    private void displayResults(Lottos lottos, WinningNumbers winningNumbers, LottoPurchase lottoPurchase) {
        LottoResults lottoResults = lottoService.calculateResults(lottos, winningNumbers, lottoPurchase);
        view.printWinningStatistics(lottoResults.getRankFrequency());
        view.printRevenue(lottoResults.getRevenue());
    }

    private void displayLottos(LottoPurchase lottoPurchase, Lottos lottos) {
        view.printPurchaseCount(lottoPurchase.getCount());
        view.printLottos(lottos);
    }

    private LottoPurchase purchaseLotto() {
        return inputHandler.handleLottoPurchase();
    }

    private WinningNumbers issueWinningNumbers() {
        Lotto winNumberLotto = inputHandler.handleWinNumbers();
        return inputHandler.handleBonusNumber(winNumberLotto);
    }

    private Lottos generateLottos(LottoPurchase lottoPurchase) {
        return lottoService.createLottos(lottoPurchase.getCount());
    }
}
