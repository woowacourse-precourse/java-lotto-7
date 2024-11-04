package lotto.domain.winning;

import static lotto.resources.Constants.FAIL_MATCH_BONUS;
import static lotto.resources.Constants.MATCH_BONUS;
import static lotto.resources.Constants.MATCH_FIVE;
import static lotto.resources.Constants.MATCH_FOUR;
import static lotto.resources.Constants.MATCH_SIX;
import static lotto.resources.Constants.MATCH_THREE;
import static lotto.resources.Constants.ZERO;

import java.util.Arrays;

public enum Rank {
    FIRST(MATCH_SIX, FAIL_MATCH_BONUS, 200000000),
    SECOND(MATCH_FIVE, MATCH_BONUS, 30000000),
    THIRD(MATCH_FIVE, FAIL_MATCH_BONUS, 1500000),
    FOURTH(MATCH_FOUR, FAIL_MATCH_BONUS, 50000),
    FIFTH(MATCH_THREE, FAIL_MATCH_BONUS, 5000),
    NOTHING(ZERO, FAIL_MATCH_BONUS, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(final int matchCount, final boolean matchBonus, final int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchingRank(matchCount, matchBonus))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean isMatchingRank(final int matchCount, final boolean matchBonus) {
        if (!this.matchBonus) {
            return this.matchCount == matchCount;
        }
        return this.matchCount == matchCount && this.matchBonus == matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonusPriority() {
        return matchBonus == MATCH_BONUS;
    }

    public int getPrize() {
        return prize;
    }
}
