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
        Integer count = getCount();
        WinningNumbers winningNumbers = getWinningNumbers();
        Lottos lottos = createLottos(count);

        displayLottos(count, lottos);
        displayResults(lottos, winningNumbers, count);
    }

    public void displayResults(Lottos lottos, WinningNumbers winningNumbers, Integer count) {
        LottoResults lottoResults = lottoService.calculateResults(lottos, winningNumbers, count);
        view.total(lottoResults.getRankFrequency());
        view.revenue(lottoResults.getRevenue());
    }

    public void displayLottos(Integer count, Lottos lottos) {
        view.count(count);
        view.lottos(lottos);
    }

    public Integer getCount() {
        Integer amount = inputHandler.handleAmount();
        return amount / 1000;
    }

    public WinningNumbers getWinningNumbers() {
        Lotto winNumberLotto = inputHandler.handleWinNumbers();
        return inputHandler.handleBonusNumber(winNumberLotto);
    }

    public Lottos createLottos(Integer count) {
        return lottoService.createLottos(count);
    }
}
