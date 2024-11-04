package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constatnt.WinningRank;
import lotto.model.Lotto;
import lotto.model.Lottos;
public class LottoPrizeCalculator {

    private final Map<WinningRank, Integer> winningCounts = new HashMap<>();

    public LottoPrizeCalculator() {
        for (WinningRank rank : WinningRank.values()) {
            winningCounts.put(rank, 0);
        }
    }

    public long calculateTotalPrize(Lottos generatedLottos, Lotto parsedWinningNumbers, int parsedWinningBonus) {
        long totalPrize = 0;

        for (Lotto lotto : generatedLottos.getLottos()) {
            int matchingNumbers = countMatchingNumbers(lotto, parsedWinningNumbers);
            boolean hasBonusNumber = lotto.getNumbers().contains(parsedWinningBonus);

            WinningRank rank = WinningRank.determineRank(matchingNumbers, hasBonusNumber);
            totalPrize += rank.getPrizeAmount();
            updateWinningCounts(rank);
        }
        return totalPrize;
    }

    private void updateWinningCounts(WinningRank rank) {
        winningCounts.put(rank, winningCounts.get(rank) + 1);
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double calculateYield(long totalPrize, int purchaseAmount) {
        double yield = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(yield * 100) / 100.0;
    }

    public Map<WinningRank, Integer> getWinningCounts() {
        return winningCounts;
    }
}