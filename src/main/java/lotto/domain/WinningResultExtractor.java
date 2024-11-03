package lotto.domain;

import java.util.*;

public class WinningResultExtractor {

    public Map<Integer, Integer> totalMatchCounts = new HashMap<>();
    public int bonusCount = 0;
    int winningAmount;

    public void getWinningResult(List<Set<Integer>> totalLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        initializeMatchCounts(totalMatchCounts);
        for (Set<Integer> lottoNumber : totalLottoNumbers) {
            countMatchingNumbers(lottoNumber, winningNumbers, bonusNumber);
        }
        totalMatchCounts.put(5, totalMatchCounts.get(5) - bonusCount);
    }

    private void initializeMatchCounts(Map<Integer, Integer> matchCounts) {
        for (int key : Arrays.asList(1, 2, 3, 4, 5, 6)) {
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

    private void getWinningAmount() {
        winningAmount = totalMatchCounts.get(3) * 5000
                + totalMatchCounts.get(4) * 50000
                + totalMatchCounts.get(5) * 1500000
                + totalMatchCounts.get(6) * 2000000000
                + bonusCount * 30000000;
    }

    public String getWinningRate(int purchaseAmount) {
        double winningRate = (double) winningAmount /purchaseAmount * 100;
        return String.format("%.1f",winningRate);
    }
}
