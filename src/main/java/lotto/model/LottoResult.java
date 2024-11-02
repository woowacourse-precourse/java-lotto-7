package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;

    public LottoResult() {
        rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0); // 모든 등수를 0으로 초기화
        }
    }

    public void incrementRankCount(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    // 전체 당첨 상금 합산
    public int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
                .sum();
    }

    // 당첨 결과 출력
    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                int count = rankCounts.get(rank);
                System.out.printf("%s (%,d원) - %d개%n", rank.getDisplayName(), rank.getPrizeMoney(), count);
            }
        }
    }
}
