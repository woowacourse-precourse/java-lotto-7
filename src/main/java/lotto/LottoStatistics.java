package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final Map<Integer, Integer> PRIZE_MAP = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    private final Map<Integer, Integer> statistics = new HashMap<>();
    private int totalPrize = 0;

    public LottoStatistics(List<List<Integer>> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        calculateStatistics(userLottos, winningNumbers, bonusNumber);
    }

    private void calculateStatistics(List<List<Integer>> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (List<Integer> lotto : userLottos) {
            int matchCount = (int) lotto.stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.contains(bonusNumber);

            if (matchCount == 5 && bonusMatch) {
                matchCount = 7; // 특별한 경우, 5개와 보너스 번호 일치
            }

            if (matchCount >= 3 || matchCount == 7) {
                statistics.put(matchCount, statistics.getOrDefault(matchCount, 0) + 1);
                totalPrize += getPrize(matchCount);
            }
        }
    }

    private int getPrize(int matchCount) {
        if (matchCount == 7) {
            return 30000000; // 2등 상금
        }
        return PRIZE_MAP.getOrDefault(matchCount, 0);
    }

    public void printStatistics(int purchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        for (int matchCount : PRIZE_MAP.keySet()) {
            int count = statistics.getOrDefault(matchCount, 0);
            int prize = PRIZE_MAP.get(matchCount);
            System.out.printf("%d개 일치 (%d원) - %d개%n", matchCount, prize, count);
        }
        if (statistics.containsKey(7)) {
            System.out.printf("5개 일치, 보너스 번호 일치 (30,000,000원) - %d개%n", statistics.get(7));
        }
        double yield = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
