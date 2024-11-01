package lotto.Constants;

/**
 * 로또 당첨금액을 정의한 enum
 */
public enum Prize {
    FIRST(6, 2_000_000_000, "2,000,000,000"),
    SECOND(5, 30_000_000, "30,000,000"),
    THIRD(5, 1_500_000, "1,500,000"),
    FOURTH(4, 50_000, "50,000"),
    FIFTH(3, 5_000, "5,000"),
    NONE(0, 0, "0");

    private final int matchCount;
    private final int prize;
    private final String prizeStr;

    Prize(int matchCount, int prize, String prizeStr) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeStr = prizeStr;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeStr() {
        return prizeStr;
    }
}
