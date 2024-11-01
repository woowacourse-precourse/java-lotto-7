package lotto.domain;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(-1, false);

    private final int matchingCount;
    private final boolean onlyHasBonus;

    Rank(int matchingCount, boolean onlySuccessBonus) {
        this.matchingCount = matchingCount;
        this.onlyHasBonus = onlySuccessBonus;
    }

    public static Rank with(int matchingCount, boolean successBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount(matchingCount) && rank.matchBonus(successBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean matchCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    private boolean matchBonus(boolean hasBonus) {
        return !this.onlyHasBonus || hasBonus;
    }

}
