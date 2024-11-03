package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    EMPTY(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    public static final int BONUS_MATCH_COUNT = 5;
    private final int prize;
    private final int matchCount;
    private final boolean bonus;

    Rank(int prize, int matchCount, boolean bonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public static Rank match(Lotto lotto, List<Integer> winNumber, int bonusNumber) {
        int matchCount = lotto.matchCount(winNumber, bonusNumber);
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.bonus == isBonus(lotto, bonusNumber, matchCount))
                .findFirst()
                .orElse(EMPTY);
    }

    private static boolean isBonus(Lotto lotto, int bonusNumber, int matchCount) {
        boolean bonus = false;
        if (matchCount == BONUS_MATCH_COUNT) {
            bonus = lotto.contain(bonusNumber);
        }
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }
}
