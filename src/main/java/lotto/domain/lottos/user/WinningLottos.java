package lotto.domain.lottos.user;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;

public class WinningLottos {
    private final List<Rank> ranks = new ArrayList<>();

    public WinningLottos() {
    }

    public void addRank(Rank rank) {
        ranks.add(rank);
    }

    public int getTotalWinningPrizeMoney(){
        int result = 0;
        for (Rank rank : ranks) {
            result += rank.getPrizeMoney();
        }
        return result;
    }


}
