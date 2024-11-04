package lotto.domain;

import java.util.Arrays;

public enum Prize {

    NO_MATCH(0, false, 0),
    THREE_MATCHES(3, false, 5_000),
    FOUR_MATCHES(4, false, 50_000),
    FIVE_MATCHES(5, false, 1_500_000),
    FIVE_MATCHES_WITH_BONUS(5, true, 30_000_000),
    SIX_MATCHES(6, false, 2_000_000_000);

    private final int requiredMatchCount;
    private final boolean requiresBonusMatch;
    private final int prize;

    Prize(int requiredMatchCount, boolean requiresBonusMatch, int prize) {
        this.requiredMatchCount = requiredMatchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
    }

    public static Prize valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(Prize.values())
                .filter(rank -> rank.isMatch(matchCount, bonusMatch))
                .min((p1, p2) -> Boolean.compare(p2.requiresBonusMatch, p1.requiresBonusMatch))
                .orElse(NO_MATCH);
    }

    public boolean isMatch(int matchCount, boolean bonusMatch) {
        if (this.requiredMatchCount != matchCount) {
            return false;
        }
        return this.requiresBonusMatch == bonusMatch || !this.requiresBonusMatch;
    }

    public String getMatchDescription() {
        if (this == FIVE_MATCHES_WITH_BONUS) {
            return "5개 일치, 보너스 볼 일치";
        }
        return this.requiredMatchCount + "개 일치";
    }

    public int getPrize() {
        return prize;
    }

}
