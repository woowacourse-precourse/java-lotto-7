package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> resultMap = new HashMap<>();

    public WinningResult() {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() >= 3) { // 5등 이상 당첨만 출력
                System.out.printf("%d개 일치", rank.getMatchCount());
                if (rank == Rank.SECOND) {
                    System.out.print(", 보너스 볼 일치");
                }
                System.out.printf(" (%d원) - %d개%n", rank.getPrize(), resultMap.get(rank));
            }
        }
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}
