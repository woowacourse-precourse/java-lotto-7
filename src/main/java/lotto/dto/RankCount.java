package lotto.dto;

import lotto.util.enums.Rank;

public class RankCount {
    private final Rank rank;
    private final int count;

    public RankCount(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }
}
