package global;

public enum LottoPrize {

    FIRST(6, false, "2,000,000"),
    SECOND(5, true, "30,000,000"),
    THIRD(5, false, "1,500,000"),
    FOURTH(4, false, "50,000"),
    FIFTH(3, false, "5,000"),
    NONE(0, false, "0");

    private final int matchNumberCount;
    private final boolean matchBonusNumber;
    private final String prizeMoney;

    LottoPrize(int matchNumberCount, boolean matchBonusNumber, String prizeMoney) {
        this.matchNumberCount = matchNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize from(long matchNumberCount, boolean matchBonusNumber) {
        for (LottoPrize prize : values()) {
            if (prize.matchNumberCount == matchNumberCount && prize.matchBonusNumber == matchBonusNumber) {
                return prize;
            }
        }
        return NONE;
    }
}
