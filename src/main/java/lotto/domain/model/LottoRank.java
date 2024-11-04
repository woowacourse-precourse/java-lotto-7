package lotto.domain.model;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, boolean matchBonus, int prize, String description) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        return java.util.Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == matchBonus)
                .findFirst()
                .orElse(getRankByMatchCount(matchCount));
    }

    private static LottoRank getRankByMatchCount(int matchCount) {
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
    public int getMatchCount() {
        return matchCount;
    }
    public String getDescription() {
        return description;
    }
}
