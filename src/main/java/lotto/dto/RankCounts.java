package lotto.dto;

import java.util.List;

public class RankCounts {
    private final List<RankCount> rankCounts;

    public RankCounts(List<RankCount> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public List<RankCount> getRankCounts() {
        return rankCounts;
    }
}
