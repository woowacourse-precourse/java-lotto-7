package lotto.model;

public class RankCount {
    private final Rank rank;
    private int count;

    public RankCount(Rank rank) {
        this.rank = rank;
        count = 0;
    }

    public void incrementCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public Rank getRank() {
        return rank;
    }
}
