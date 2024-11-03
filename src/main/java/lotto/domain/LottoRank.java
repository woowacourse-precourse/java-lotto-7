package lotto.domain;

public enum LottoRank {
    FIFTH(3, false, 5000, "5,000"),
    FOURTH(4, false, 50000, "50,000"),
    THIRD(5, false, 1500000, "1,500,000"),
    SECOND(5, true, 30000000, "30,000,000"),
    FIRST(6, false, 2000000000, "2,000,000,000"),
    NONE(0, false, 0, "0");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String outputPrize;

    LottoRank(int matchCount, boolean matchBonus, int prize, String standardOutputPrize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.outputPrize = standardOutputPrize;
    }

    public int getPrize() {
        return prize;
    }

    public String getOutputPrize() {
        return outputPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static String valueOf(int matchCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank.name();
            }
        }
        return "NONE";
    }
}

