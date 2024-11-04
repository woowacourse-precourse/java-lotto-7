package lotto.enums;

import java.util.Arrays;

public enum Rank {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int winningAmount;

    Rank(int matchCount, boolean requiresBonus, int winningAmount) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.winningAmount = winningAmount;
    }

    public static Rank getRank(int matchCount, boolean containsBonus) {
        if (matchCount == 5) {
            return Arrays.stream(values())
                    .filter(rank -> rank.matchCount == matchCount && rank.requiresBonus == containsBonus)
                    .findFirst()
                    .orElse(NONE);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
