package lotto.domain.lottos.user;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Wallet;

public class WinningLotto {
    private final EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);

    public WinningLotto() {
        initRanks();
    }

    public void addRank(Rank rank) {
        ranks.merge(rank, 1, Integer::sum);
    }

    public void calculateRateOfReturn(Wallet wallet) {
        wallet.calculateRateOfReturn(getFinalPrizeAmount());
    }

    private long getFinalPrizeAmount() {
        long result = 0;

        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            long prizeMoney = rank.getPrizeMoney();

            if (count > 0) {
                result += prizeMoney * count;
            }
        }
        return result;
    }

    public EnumMap<Rank, Integer> getWinningStatistics() {
        return ranks;
    }

    private void initRanks() {
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
    }

}
