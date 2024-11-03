package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int reward;
    private final boolean requireBonusNumber;

    Rank(final int matchCount, final int reward) {
        this(matchCount, reward, false);
    }

    Rank(final int matchCount, final int reward, final boolean requireBonusNumber) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.requireBonusNumber = requireBonusNumber;
    }

    public static Rank getRank(final int matchCount, boolean containBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> {
                    if (rank.matchCount == 5) {
                        return rank.requireBonusNumber == containBonusNumber;
                    }
                    return true;
                })
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }
}
