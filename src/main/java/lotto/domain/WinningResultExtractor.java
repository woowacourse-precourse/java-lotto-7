package lotto.domain;

import java.util.*;

public class WinningResultExtractor {

    public Map<Integer, Integer> totalMatchCounts = new HashMap<>();
    public int bonusCount = 0;

    private enum WinningAmount {
        THREE(5000),
        FOUR(50000),
        FIVE(1500000),
        SIX(2000000000),
        BONUS(30000000);

        private final int amount;

        WinningAmount(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }

    public void getWinningResult(List<Set<Integer>> totalLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        initializeMatchCounts(totalMatchCounts);

        for (Set<Integer> lottoNumber : totalLottoNumbers) {
            countMatchingNumbers(lottoNumber, winningNumbers, bonusNumber);
        }
        totalMatchCounts.put(5, totalMatchCounts.get(5) - bonusCount);
    }

    private void initializeMatchCounts(Map<Integer, Integer> matchCounts) {
        for (int key : Arrays.asList(1, 2, 3, 4, 5, 6, 7)) {
            matchCounts.put(key, 0);
        }
    }

    private void countMatchingNumbers(Set<Integer> lottoNumber, List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if (lottoNumber.contains(winningNumber)) {
                matchingCount++;
            }
        }
        totalMatchCounts.put(matchingCount, totalMatchCounts.getOrDefault(matchingCount, 0) + 1);

        if (matchingCount == 5 && lottoNumber.contains(bonusNumber)) {
            bonusCount++;
        }
    }

    private int getWinningAmount() {
        return WinningAmount.THREE.getAmount() * totalMatchCounts.get(3)
                + WinningAmount.FOUR.getAmount() * totalMatchCounts.get(4)
                + WinningAmount.FIVE.getAmount() * totalMatchCounts.get(5)
                + WinningAmount.SIX.getAmount() * totalMatchCounts.get(6)
                + WinningAmount.BONUS.getAmount() * bonusCount;
    }

    public String getWinningRate(int purchaseAmount) {
        double winningRate = (double) getWinningAmount() / purchaseAmount * 100;
        return String.format("%.1f", winningRate);
    }
}
