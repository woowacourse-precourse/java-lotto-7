package lotto;

public class Result {
    private Rank rank;
    private int wonCount;

    public Result(Rank rank) {
        this.rank = rank;
        this.wonCount = 0;
    }

    public Rank getRank() { return rank; }
    public int getWonCount() { return wonCount; }

    public void increaseWonCount() { wonCount++; }
}