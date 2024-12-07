package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        int purchaseCount = getPurchaseCount();
        if (purchaseCount < 0) {
            return; // If invalid input was given, just return. (Or handle retry logic)
        }

        lottoService.purchaseLottos(purchaseCount);
        OutputView.printPurchasedLottos(lottoService.getPurchasedLottos());

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        lottoService.setWinningNumbers(winningNumbers, bonusNumber);

        Map<Rank, Integer> rankCounts = lottoService.calculateRankCounts();
        long totalPrize = lottoService.calculateTotalPrize(rankCounts);
        double profitRate = lottoService.calculateProfitRate(totalPrize);

        OutputView.printResults(rankCounts, profitRate);
    }

    private int getPurchaseCount() {
        int purchaseAmount = InputView.getPurchaseAmount();
        if (purchaseAmount <= 0) {
            OutputView.printError("[ERROR] 유효한 금액을 입력해 주세요.");
            return -1;
        }
        int purchaseCount = purchaseAmount / 1000;
        OutputView.printPurchaseCount(purchaseCount);
        return purchaseCount;
    }
}
