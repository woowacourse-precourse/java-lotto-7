package lotto.entity;

import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, false, 2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    NONE(0, false, 0, (count, bonus) -> count <= 2);

    private final int matchCount;
    private final boolean hasBonus;
    private final long prize;
    private final BiPredicate<Integer, Boolean> criteria;

    Rank(int matchCount, boolean hasBonus, long prize, BiPredicate<Integer, Boolean> criteria) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.criteria = criteria;
    }

    public static Rank getRank(int count, boolean bonus) {
        for (Rank rank : values()) {
            if (rank.criteria.test(count, bonus)) {
                return rank;
            }
        }
        return NONE;
    }

    public long getPrize() {
        return prize;
    }
}
