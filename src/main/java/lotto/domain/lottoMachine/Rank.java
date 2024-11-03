package lotto.domain.lottoMachine;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    NONE(0, 0),

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int reward;

    Rank(final int matchCount, final int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank getRank(final int matchCount, final boolean isContainsBonusNumber) {
        if (matchCount == SECOND.matchCount && isContainsBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rating -> rating.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static List<Rank> getRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(NONE))
                .toList();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
