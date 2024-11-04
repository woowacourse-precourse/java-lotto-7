package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST(2000000000, 6, true, 0),
    SECOND(30000000, 5, true, 1),
    THIRD(1500000, 5, false, 2),
    FOURTH(50000, 4, false, 3),
    FIFTH(5000, 3, false, 4),
    NONE(0, 0, false, 5);

    private final int prize;
    private final int matchCount;
    private final boolean requiresBonus;
    private final int index;

    Rank(int prize, int matchCount, boolean requiresBonus, int index) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.index = index;
    }

    public int getPrize() {
        return prize;
    }

    public int getIndex() {
        return index;
    }

    public static Rank determineRank(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean isBonus = lotto.contains(bonusNumber);

        return findRank((int) matchCount, isBonus);
    }

    private static Rank findRank(int matchCount, boolean isBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && (!rank.requiresBonus || isBonus)) {
                return rank;
            }
        }
        return Rank.NONE;
    }
}
