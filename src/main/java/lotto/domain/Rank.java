package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    NONE(0, 0),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private final int prize;
    private final int match;

    Rank(int prize, int match) {
        this.prize = prize;
        this.match = match;
    }

    public static Rank of(int match, boolean isBonus) {
        if (isBonus && match == 5) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(match))
                .findFirst()
                .orElse(NONE);
    }

    public static List<Rank> getWithoutNone() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(NONE))
                .toList();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }

    private boolean isMatch(int match) {
        return this.match == match;
    }
}
