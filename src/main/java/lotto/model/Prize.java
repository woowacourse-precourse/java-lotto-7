package lotto.model;

public class Prize {
    private final PrizeRank prizeRank;
    private int count;

    public Prize(PrizeRank prizeRank) {
        this.prizeRank = prizeRank;
        this.count = 0;
    }

    public void incrementCount() {
        this.count++;
    }

    public PrizeRank getPrizeRank() {
        return prizeRank;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrize() {
        return prizeRank.getPrizeAmount() * count;
    }
}
