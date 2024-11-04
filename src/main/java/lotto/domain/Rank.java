package lotto.domain;

import java.util.Arrays;

public enum Rank {
    SIX_MATCHES("6개 일치", 6, false, 2_000_000_000),
    FIVE_MATCHES_WITH_BONUS("5개 일치, 보너스 볼 일치", 5, true, 30_000_000),
    FIVE_MATCHES("5개 일치", 5, false, 1_500_000),
    FOUR_MATCHES("4개 일치", 4, false, 50_000),
    THREE_MATCHES("3개 일치", 3, false, 5_000),
    NO_MATCH("꽝", 0, false, 0);

    private final String matchDescription;
    private final int requiredMatchCount;
    private final boolean requiresBonusMatch;
    private final int prize;

    Rank(String matchDescription, int requiredMatchCount, boolean requiresBonusMatch, int prize) {
        this.matchDescription = matchDescription;
        this.requiredMatchCount = requiredMatchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount, bonusMatch))
                .findFirst()
                .orElse(NO_MATCH);
    }

    public boolean isMatch(int matchCount, boolean bonusMatch) {
        if (this.requiredMatchCount != matchCount) {
            return false;
        }
        return this.requiresBonusMatch == bonusMatch || !this.requiresBonusMatch;
    }

    public String getMatchDescription() {
        return matchDescription;
    }

    public int getPrize() {
        return prize;
    }

}
