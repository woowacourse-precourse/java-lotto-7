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
        WinningNumbers winningNumbers = getWinningNumbers();
        Lottos lottos = createLottos(lottoPurchase);

        displayLottos(lottoPurchase, lottos);
        displayResults(lottos, winningNumbers, lottoPurchase);
    }

    public void displayResults(Lottos lottos, WinningNumbers winningNumbers, LottoPurchase lottoPurchase) {
        LottoResults lottoResults = lottoService.calculateResults(lottos, winningNumbers, lottoPurchase);
        view.printWinningStatistics(lottoResults.getRankFrequency());
        view.printRevenue(lottoResults.getRevenue());
    }

    public void displayLottos(LottoPurchase lottoPurchase, Lottos lottos) {
        view.printPurchaseCount(lottoPurchase.getCount());
        view.printLottos(lottos);
    }

    public LottoPurchase purchaseLotto() {
        return inputHandler.handleAmount();
    }

    public WinningNumbers getWinningNumbers() {
        Lotto winNumberLotto = inputHandler.handleWinNumbers();
        return inputHandler.handleBonusNumber(winNumberLotto);
    }

    public Lottos createLottos(LottoPurchase lottoPurchase) {
        return lottoService.createLottos(lottoPurchase.getCount());
    }
}
