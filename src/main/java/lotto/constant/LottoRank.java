package lotto.constant;

public enum LottoRank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FORTH(50_000),
    FIFTH(5_000);

    private int prize;
    private int numberOfWins;

    LottoRank(int prize) {
        this.prize = prize;
        this.numberOfWins = 0;
    }

    public int getPrize() {
        return prize;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void win() {
        this.numberOfWins++;
    }

    public int getTotalPrize() {
        return (prize * numberOfWins);
    }
}
