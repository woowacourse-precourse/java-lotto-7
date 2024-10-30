package lotto.domain.lottos.user;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Rank;

/**
 * 맵 초기화?
 */
public class WinningLottos {
    //private final List<Rank> rankss = new ArrayList<>();

    private final EnumMap<Rank,Integer> ranks = new EnumMap<>(Rank.class);

    public WinningLottos() {
        initRanks();
    }

    public void addRank(Rank rank) {
        ranks.merge(rank,1,Integer::sum);
    }

    public int getTotalWinningPrizeMoney(){
        int result = 0;

        for (Rank rank : ranks.keySet()) {
            result += rank.getPrizeMoney();
        }
        return result;
    }

    private void initRanks(){
        for (Rank rank : Rank.values()) {
            ranks.put(rank,0);
        }
    }

    public EnumMap<Rank,Integer> getWinningStatistics(){
        return ranks;
    }


}
