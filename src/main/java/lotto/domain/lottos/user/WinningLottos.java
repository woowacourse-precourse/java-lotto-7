package lotto.domain.lottos.user;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Wallet;

/**
 * 맵 초기화?
 */
public class WinningLottos {
    private final EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);

    public WinningLottos() {
        initRanks();
    }

    public void addRank(Rank rank) {
        ranks.merge(rank, 1, Integer::sum);
    }

    public void calculateRateOfReturn(Wallet wallet) {
        wallet.calculateRateOfReturn(getFinalPrizeAmount());
    }

    //마지막 한번만 필요한 결과이기때문에 필드로 생성하지 않음
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

    private void initRanks() {
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
    }

    public EnumMap<Rank, Integer> getWinningStatistics() {
        return ranks;
    }

}
