package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    ZERO(0, false);

    private long matchCount;
    private boolean matchBonus;

    Rank(long matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static Rank findRank(long matchCount, boolean matchBonus) {
        return Arrays.stream(values()).filter(v -> v.matchCount == matchCount && v.matchBonus == matchBonus)
                .findFirst()
                .orElse(ZERO);
    }
}
