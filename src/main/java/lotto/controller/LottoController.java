package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningResultCalculator;
import lotto.view.OutputView;

public class LottoController {
    private final LottoIssuer lottoIssuer;
    private final InputHandler inputController;
    private final OutputView outputView;

    public LottoController(LottoIssuer lottoIssuer,
                           InputHandler inputController, OutputView outputView) {
        this.lottoIssuer = lottoIssuer;
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {

        int purchaseAmount = inputController.getValidatedPurchaseAmount();
        PurchaseAmount amount = new PurchaseAmount(purchaseAmount);

        int lottoCount = amount.calculateNumberOfLottos();
        List<Lotto> issuedLottos = lottoIssuer.issueLottos(lottoCount);
        outputView.printIssuedLottos(issuedLottos);

        List<Integer> winningNumbers = inputController.getWinningNumbers();
        int bonusNumber = inputController.getBonusNumber(winningNumbers);

        WinningResultCalculator resultsCalculator = WinningResultCalculator.of(issuedLottos, winningNumbers, bonusNumber);
        outputView.printResults(resultsCalculator.getResults());

        double profitRate = resultsCalculator.calculateProfitRate(purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

}