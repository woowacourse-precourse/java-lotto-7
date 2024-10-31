package lotto.Controller;

public class LottoController {
    private final LottoService;
    private final InputView;
    private final OutputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int budget = InputView.getBudget();
        OutputView.printMyLottos(budget);
        String numbers = InputView.getNumbers();
        LottoService.getStatistics(budget, numbers);
        OutputViews.printStatistics(budget, numbers);
    }
}
