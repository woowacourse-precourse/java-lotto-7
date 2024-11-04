package lotto;

public enum LottoRank {
    RANK_1(6, false, 2000000000),
    RANK_2(5, true, 30000000),
    RANK_3(5, false, 1500000),
    RANK_4(4, false, 50000),
    RANK_5(3, false, 5000);

    private final int matchNumber;
    private final boolean bonusNumber;
    private final int prizeMoney;

    LottoRank(int matchNumber, boolean bonusNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.bonusNumber = bonusNumber;
        this.prizeMoney = prizeMoney;
    }

    static LottoRank getRank(int matchNumber, boolean bonusNumber) {
        for (LottoRank rank : values()) {
            if (rank.matchNumber == matchNumber && rank.bonusNumber == bonusNumber) {
                return rank;
            }
        }
        return null;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
