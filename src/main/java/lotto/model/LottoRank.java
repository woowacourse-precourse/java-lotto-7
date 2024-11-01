package lotto.model;

public enum LottoRank {

    FIRST("6개 일치 (2,000,000,000원)", 2000000000L),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000L),
    THIRD("5개 일치 (1,500,000원)", 1500000L),
    FOURTH("4개 일치 (50,000원)", 50000L),
    FIFTH("3개 일치 (5,000원)", 5000L),
    NO_LUCK("3개 미만 일치 (0원)", 0L);

    private final String description;
    private final long winningAmount;

    LottoRank(String description, long winningAmount) {
        this.description = description;
        this.winningAmount = winningAmount;
    }

    public static LottoRank matchRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6 && !matchBonus) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5 && !matchBonus) {
            return THIRD;
        }
        if (matchCount == 4 && !matchBonus) {
            return FOURTH;
        }
        if (matchCount == 3 && !matchBonus) {
            return FIFTH;
        }
        return NO_LUCK;
    }

    public String getDescription() {
        return description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
