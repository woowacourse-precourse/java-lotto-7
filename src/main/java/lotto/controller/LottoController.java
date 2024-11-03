package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningResultCalculator;
import lotto.view.OutputView;

public class LottoController {
    private final LottoIssuer lottoIssuer;
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public LottoController(LottoIssuer lottoIssuer, InputHandler inputHandler, OutputView outputView) {
        this.lottoIssuer = lottoIssuer;
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void run() {

        int purchaseAmount = inputHandler.getPurchaseAmount();
        List<Lotto> Lottos = createLottos(purchaseAmount);
        outputView.printIssuedLottos(Lottos);

        WinningResultCalculator resultsCalculator = createResultCalculator(Lottos);
        List<LottoResult> results = resultsCalculator.getResults();
        outputView.printResults(results);

        double profitRate = resultsCalculator.calculateProfitRate(purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

    private WinningResultCalculator createResultCalculator(List<Lotto> issuedLottos) {
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber(winningNumbers);
        return WinningResultCalculator.of(issuedLottos, winningNumbers, bonusNumber);
    }

    private List<Lotto> createLottos(int purchaseAmount) {
        PurchaseAmount amount = new PurchaseAmount(purchaseAmount);
        int lottoCount = amount.calculateNumberOfLottos();
        return lottoIssuer.issueLottos(lottoCount);
    }

}