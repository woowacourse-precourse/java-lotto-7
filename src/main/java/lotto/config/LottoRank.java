package lotto.config;

public enum LottoRank {

    NON_RANK(0, false, 0L),
    FIFTH_RANK(3, false, 5_000L),
    FOURTH_RANK(4, false, 50_000L),
    THIRD_RANK(5, false, 1_500_000L),
    SECOND_RANK(5, true, 30_000_000L),
    FIRST_RANK(6, false, 2_000_000_000L);

    private final Integer matchCount;
    private final boolean containsBonusNumber;
    private final Long prizeMoney;

    LottoRank(final Integer matchCount,
              final boolean containsBonusNumber,
              final Long prizeMoney) {
        this.matchCount = matchCount;
        this.containsBonusNumber = containsBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isContainsBonusNumber() {
        return containsBonusNumber;
    }

    public static LottoRank getRankByMatches(final Integer matchCount) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount.equals(matchCount)) {
                return lottoRank;
            }
        }
        return NON_RANK;
    }
}
