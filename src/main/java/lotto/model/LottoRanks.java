package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRanks {
    private final Map<LottoRank, Integer> lottoRanks = new EnumMap<>(LottoRank.class);

    public LottoRanks(Lottos lottos, WinLotto winLotto) {
        List<LottoRank> ranks = winLotto.matchLottos(lottos);

        for (LottoRank rank : ranks) {
            lottoRanks.put(rank, lottoRanks.getOrDefault(rank, 0) + 1);
        }
    }

    public int getRankCount(LottoRank rank) {
        return lottoRanks.getOrDefault(rank, 0);
    }

    public long getProfit() {
        return lottoRanks.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double getReturnRate(PurchaseAmount purchaseAmount) {
        return (double) getProfit() / purchaseAmount.getAmount();
    }
}
