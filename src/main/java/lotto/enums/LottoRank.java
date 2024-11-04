package lotto.enums;

public enum LottoRank {
    FIRST_RANK(1, 6, 2_000_000_000, "2,000,000,000"),
    SECOND_RANK(2, 5, 30_000_000, "30,000,000"),
    THIRD_RANK(3, 5, 1_500_000, "1,500,000"),
    FOURTH_RANK(4, 4, 50_000, "50,000"),
    FIFTH_RANK(5, 3, 5_000, "5,000"),
    NONE_RANK(0, 0, 0, "0");

    private final int rank;
    private final int count;
    private final int prize;
    private final String prizeInfo;

    LottoRank(int rank, int count, int prize, String prizeInfo) {
        this.rank = rank;
        this.count = count;
        this.prize = prize;
        this.prizeInfo = prizeInfo;
    }

    public int getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeInfo() {
        return prizeInfo;
    }

    public static LottoRank getEnumsValue(int rank) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getRank() == rank) {
                return lottoRank;
            }
        }
        return NONE_RANK;
    }
}
