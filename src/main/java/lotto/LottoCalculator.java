package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {
    public static final int MATCH_FIVE_BONUS = 5;

    public static int countMatches(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean countMatchesWithBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static Rank calculateRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatches(lotto, winningNumbers);
        boolean matchBonus = false;
        if (matchCount == MATCH_FIVE_BONUS) {
            matchBonus = countMatchesWithBonus(lotto, bonusNumber);
        }
        return Rank.of(matchCount, matchBonus);
    }

    public static Map<Rank, Integer> calculateTotalRank(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }
        return rankCountMap;
    }

    public static void printRank(Map<Rank, Integer> rankCountMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s - %d개\n", rank.getResult(), rankCountMap.getOrDefault(rank, 0));
            }
        }
    }

    public static long calculateTotalReward(Map<Rank, Integer> rankCount) {
        long totalReward = 0;
        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            Rank rank = entry.getKey();
            long count = entry.getValue();
            totalReward += rank.getReward() * count;
        }
        return totalReward;
    }

    public static double calculateProfitRate(long totalReward, int purchaseAmount) {
        double profitRate = (double) totalReward / purchaseAmount * 100;
        profitRate = Math.round(profitRate * 10) / 10.0; // 소수점 둘째 자리에서 반올림
        return profitRate;
    }

}
