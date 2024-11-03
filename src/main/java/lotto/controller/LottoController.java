package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.service.PrizeCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private static final double PERCENTAGE_MULTIPLIER = 100.0;  // 수익률 계산을 위한 상수

    private final LottoService lottoService = new LottoService();
    private final PrizeCalculator prizeCalculator = new PrizeCalculator();

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
        displayPurchasedLottos(purchasedLottos);

        WinningNumbers winningNumbers = getWinningNumbers();
        Map<Rank, Integer> rankResults = calculateResults(purchasedLottos, winningNumbers);
        displayResults(rankResults);

        displayProfitRate(rankResults, purchaseAmount);
    }

    private int getPurchaseAmount() {
        return InputView.getPurchaseAmount();
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        return lottoService.purchaseLottos(purchaseAmount);
    }

    private void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        OutputView.displayPurchasedLottos(purchasedLottos);
    }

    private WinningNumbers getWinningNumbers() {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> calculateResults(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> rankResults = new HashMap<>();
        for (Lotto lotto : purchasedLottos) {
            Rank rank = prizeCalculator.calculateRank(lotto, winningNumbers);
            rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
        }
        return rankResults;
    }

    private void displayResults(Map<Rank, Integer> rankResults) {
        OutputView.displayResults(rankResults);
    }

    private void displayProfitRate(Map<Rank, Integer> rankResults, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(rankResults);
        double profitRate = (double) totalPrize / purchaseAmount * PERCENTAGE_MULTIPLIER;
        OutputView.displayProfitRate(profitRate);
    }

    private int calculateTotalPrize(Map<Rank, Integer> rankResults) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankResults.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }
}
