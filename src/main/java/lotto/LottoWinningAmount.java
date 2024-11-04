package lotto;

public enum LottoWinningAmount {
    FIRST(1, "6개 일치", 2000000000),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30000000),
    THIRD(3, "5개 일치", 1500000),
    FOURTH(4, "4개 일치", 50000),
    FIFTH(5, "3개 일치", 5000),
    BUSTED(6, "꽝", 0);

    private final int rank;
    private final String match;
    private final long winning;

    LottoWinningAmount(int rank, String match, long winning) {
        this.rank = rank;
        this.match = match;
        this.winning = winning;
    }

    public int getRank() {
        return rank;
    }

    public String getMatch() {
        return match;
    }

    public long getWinning() {
        return winning;
    }

    public static LottoWinningAmount findByRank(int rank) {
        for (LottoWinningAmount winning : LottoWinningAmount.values()) {
            if (winning.rank == rank) {
                return winning;
            }
        }
        return BUSTED;
    }
}
