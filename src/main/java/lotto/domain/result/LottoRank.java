package lotto.domain.result;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    NONE(0, 0, "미당첨");

    private final int matchCount;
    private final int prizeMoney;
    private final String description;

    LottoRank(int matchCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static LottoRank of(int matchCount, boolean hasBonusNumber) {
        if (isSecondRank(matchCount, hasBonusNumber)) {
            return SECOND;
        }
        return findByMatchCount(matchCount);
    }

    private static boolean isSecondRank(int matchCount, boolean hasBonusNumber) {
        return matchCount == 5 && hasBonusNumber;
    }

    private static LottoRank findByMatchCount(int matchCount) {
        for (LottoRank rank : values()) {
            if (rank.isMatchCount(matchCount) && rank != SECOND) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
