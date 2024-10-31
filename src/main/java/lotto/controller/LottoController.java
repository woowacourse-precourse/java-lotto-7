package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoResult;
import lotto.domain.ProfitCalculator;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningResultCalculator;
import lotto.view.OutputView;

public class LottoController {
    private final LottoIssuer lottoIssuer;
    private final WinningResultCalculator winningResultCalculator;
    private final InputController inputController;
    private final OutputView outputView;

    public LottoController(LottoIssuer lottoIssuer, WinningResultCalculator winningResultCalculator,
                           InputController inputController, OutputView outputView) {
        this.lottoIssuer = lottoIssuer;
        this.winningResultCalculator = winningResultCalculator;
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

        List<LottoResult> results = winningResultCalculator.calculateResults(issuedLottos, winningNumbers, bonusNumber);
        int totalWinnings = winningResultCalculator.calculateTotalWinnings(results);
        double profitRate = ProfitCalculator.calculateProfitRate(totalWinnings, purchaseAmount);

        outputView.printResults(results);
        outputView.printProfitRate(profitRate);
    }

}