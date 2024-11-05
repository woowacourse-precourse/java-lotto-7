package lotto.domain;

import java.util.Optional;

public enum PrizeTier {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchingCount;
    private final boolean matchBonus;
    private final int prize;

    PrizeTier(int matchingCount, boolean matchBonus, int prize) {
        this.matchingCount = matchingCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    public static Optional<PrizeTier> getPrizeTier(int matchingCount, boolean matchBonus) {
        for (PrizeTier tier : values()) {
            if (tier.matchingCount == matchingCount && tier.matchBonus == matchBonus) {
                return Optional.of(tier);
            }
        }
        return Optional.empty();
    }
}