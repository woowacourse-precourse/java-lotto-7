package lotto.model.constant;

public enum LottoRank {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000),
    OTHERS(6, 0);

    private final int number;
    private final int winningPrize;

    LottoRank(int number, int winningPrize) {
        this.number = number;
        this.winningPrize = winningPrize;
    }

    public int getNumber() {
        return number;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
