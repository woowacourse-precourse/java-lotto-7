package lotto.dto;

import lotto.rank.Rank;

public class Result {
    private final Rank rank;
    private int count;

    public Result(Rank rank) {
        this.rank = rank;
        this.count = 0;
    }

    public void countUp() {
        this.count += 1;
    }

    public boolean isSame(Rank rank) {
        return this.rank == rank;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }
}
