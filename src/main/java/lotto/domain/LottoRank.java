package lotto.domain;

public enum LottoRank {

    NO_WINNING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 5_0000),
    THIRD(5, 150_0000),
    SECOND(5, 3000_0000),
    FIRST(6, 20_0000_0000);

    private int sameNumberCount;
    private int winningPrice;

    LottoRank(int sameNumberCount, int winningPrice) {
        this.sameNumberCount = sameNumberCount;
        this.winningPrice = winningPrice;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
