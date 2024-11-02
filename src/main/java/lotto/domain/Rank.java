package lotto.domain;

public enum Rank {
    FIFTH(5, 3, false, 5000L, "오천"),
    FOURTH(4, 4, false, 50000L, "오만"),
    THIRD(3, 5, false, 1500000L, "백오십만"),
    SECOND(2, 5, true, 30000000L, "삼천만"),
    FIRST(1, 6, false, 2000000000L, "이십억"),
    NOTHING(-1, 0, false, 0L, "영");

    private final int rank;
    private final int matchCount;
    private final boolean hasBonus;
    private final Long prizeMoney;
    private final String prizeMoneyKorean;

    Rank(int rank, int matchCount, boolean hasBonus,
         Long prizeMoney, String prizeMoneyKorean) {
        this.hasBonus = hasBonus;
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyKorean = prizeMoneyKorean;
    }

    public static Rank findRank(int matchCount, boolean hasBonus) {
        if (SECOND.matchCount == matchCount) {
            if (SECOND.hasBonus == hasBonus) {
                return SECOND;
            }
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return NOTHING;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

}
