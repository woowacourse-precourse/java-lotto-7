package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results;

    private LottoResult() {
        results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public static LottoResult of(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        lottos.forEach(lotto -> result.addResult(winningLotto.match(lotto)));
        return result;
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            totalPrize += entry.getKey().getPrice() * entry.getValue();
        }

        return (totalPrize * 100.0) / purchaseAmount;
    }
}
