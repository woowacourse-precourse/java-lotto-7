package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoWinningStatics {
    private static final Map<Integer, Long> PRIZE_MONEY = Map.of(
            3, 5000L,
            4, 50000L,
            5, 1500000L,
            6, 2000000000L
    );

    private static final long BONUS_PRIZE = 30000000L;
    private List<Lotto> lottos;
    private LottoDrawMachine lottoDrawMachine;
    private int purchaseAmount;

    public LottoWinningStatics(List<Lotto> lottos, LottoDrawMachine lottoDrawMachine, int purchaseAmount) {
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
        matchCountMap.put(7, 0);
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
            matchCountMap.put(7, matchCountMap.get(7) + 1);
        } else if (matchCount >= 3) {
            matchCountMap.put(matchCount, matchCountMap.get(matchCount) + 1);
        }
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int num : lottoNumbers) {
            if (winningNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public double calculateYield() {
        double totalWinnings = 0.0;
        Map<Integer, Integer> matchCountMap = calculateStatistics();

        for (int i = 3; i <= 6; i++) {
            totalWinnings += (double) PRIZE_MONEY.get(i) * matchCountMap.get(i);
        }
        totalWinnings += (double) BONUS_PRIZE * matchCountMap.get(7);

        if (totalWinnings < purchaseAmount) {
            return ((totalWinnings - purchaseAmount) / purchaseAmount) * 100;
        }

        return (totalWinnings / purchaseAmount) * 100;
    }

}