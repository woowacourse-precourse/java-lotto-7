package lotto.domain;

import java.util.Arrays;

public enum Rank {

    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int correctCount;
    private final int prize;
    private final boolean hasBonus;

    Rank(int correctCount, int prize, boolean hasBonus) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static Rank find(int count, boolean isBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.match(count, isBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean match(int count, boolean isBonus) {
        if (this == FIRST) {
            return count == this.correctCount;
        }

        if (this == SECOND || this == THIRD) {
            return count == this.correctCount && isBonus == this.hasBonus;
        }

        return count == this.correctCount;
    }

    public long calculatePrize(int count) {
        return (long) prize * count;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getBonus() {
        return hasBonus;
    }
}
