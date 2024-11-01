package lotto.domain.rank;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.vo.Rank;

import java.util.HashMap;
import java.util.List;

public class RankManager {
    private final HashMap<Rank, Integer> rankInfo;

    public RankManager(HashMap<Rank, Integer> rankInfo) {
        this.rankInfo = rankInfo;
    }

    public static RankManager from(List<Lotto> lottos, WinningLotto winningLotto) {
        return new RankManager(null);
    }

    @Override
    public String toString() {
        return "";
    }

    public int getRevenue() {
        return 0;
    }
}
