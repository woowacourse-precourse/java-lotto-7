package lotto.handler.rank.dto;

import java.util.HashMap;
import lotto.handler.purchase.process.WinningRank;

public class RankCountsDTO {
    private HashMap<WinningRank, Integer> rankCounts;

    private RankCountsDTO(HashMap<WinningRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public HashMap<WinningRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public void setRankCounts(HashMap<WinningRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public static RankCountsDTO create(HashMap<WinningRank, Integer> rankCounts) {
        return new RankCountsDTO(rankCounts);
    }
}
