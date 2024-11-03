package lotto.domain;

public class RankResult {
    private final RankType rank;
    private int count;
    private int prize;

    public RankResult(RankType rank) {
        this.rank = rank;
        this.count = 0;
        this.prize = 0;
    }

    public void increment() {
        count++;
        prize += rank.getPrize();
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }
}