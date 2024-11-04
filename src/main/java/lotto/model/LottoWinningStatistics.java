package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoWinningStatistics {
    private List<Lotto> lottos;
    private LottoDrawMachine lottoDrawMachine;
    private int purchaseAmount;

    public LottoWinningStatistics(List<Lotto> lottos, LottoDrawMachine lottoDrawMachine, int purchaseAmount) {
        this.lottos = lottos;
        this.lottoDrawMachine = lottoDrawMachine;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Integer, Integer> calculateStatistics() {
        Map<Integer, Integer> matchCountMap = initializeMatchCountMap();
        calculateWinnings(matchCountMap);
        return matchCountMap;
    }

    private Map<Integer, Integer> initializeMatchCountMap() {
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (int i = 3; i <= 6; i++) {
            matchCountMap.put(i, 0);
        }
        matchCountMap.put(7, 0); // For bonus matches
        return matchCountMap;
    }

    private void calculateWinnings(Map<Integer, Integer> matchCountMap) {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), lottoDrawMachine.getWinningNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(lottoDrawMachine.getBonusNumber());

            updateMatchCount(matchCountMap, matchCount, bonusMatch);
        }
    }

    private void updateMatchCount(Map<Integer, Integer> matchCountMap, int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            matchCountMap.put(7, matchCountMap.get(7) + 1); // Bonus match
        } else if (matchCount >= 3) {
            matchCountMap.put(matchCount, matchCountMap.get(matchCount) + 1);
        }
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    public double calculateYield() {
        double totalWinnings = calculateTotalWinnings();

        if (totalWinnings > purchaseAmount) {
            return (totalWinnings / purchaseAmount) * 100;
        }
        return ((totalWinnings - purchaseAmount) / purchaseAmount) * 100;
    }


    private double calculateTotalWinnings() {
        double totalWinnings = 0.0;
        Map<Integer, Integer> matchCountMap = calculateStatistics();

        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() <= 6) {
                totalWinnings += (double) prize.getPrizeAmount() * matchCountMap.get(prize.getMatchCount());
            }
        }
        totalWinnings += (double) Prize.BONUS.getPrizeAmount() * matchCountMap.get(7);
        return totalWinnings;
    }
}
