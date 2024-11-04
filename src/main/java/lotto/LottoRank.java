package lotto;

public enum LottoRank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    NONE(0, 0, "꽝");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank fromMatchCount(int matchCount, boolean hasBonus) {
        if (matchCount == FIRST.getMatchCount()) {
            return FIRST;
        }
        if (matchCount == SECOND.getMatchCount() && hasBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.getMatchCount()) {
            return THIRD;
        }
        if (matchCount == FOURTH.getMatchCount()) {
            return FOURTH;
        }
        if (matchCount == FIFTH.getMatchCount()) {
            return FIFTH;
        }
        return NONE;
    }
}
