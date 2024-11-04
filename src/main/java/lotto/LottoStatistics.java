package lotto;

import java.util.Map;

public class LottoStatistics {
    public double calculateYield(int money, Map<String, Integer> winningResult) {
        long totalPrize =
                (winningResult.get("MATCH_3") * 5_000) +
                        (winningResult.get("MATCH_4") * 50_000) +
                        (winningResult.get("MATCH_5") * 1_500_000) +
                        (winningResult.get("MATCH_5_BONUS") * 30_000_000) +
                        (winningResult.get("MATCH_6") * 2_000_000_000L);
        return ((double) totalPrize / money) * 100;
    }
}
