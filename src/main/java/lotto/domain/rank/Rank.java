package lotto.domain.rank;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    NONE(0,
            0,
            false,
            (count, isBonus) -> count < 3),
    FIFTH(3,
            5_000,
            false,
            (count, isBonus) -> count.equals(3)),
    FOURTH(4,
            50_000,
            false,
            (count, isBonus) -> count.equals(4)),
    THIRD(5,
            1_500_000,
            false,
            (count, isBonus) -> count.equals(5) && !isBonus),
    SECOND(5,
            30_000_000,
            true,
            (count, isBonus) -> count.equals(5) && isBonus),
    FIRST(6,
            2_000_000_000,
            false,
            (count, isBonus) -> count.equals(6));

    private final int correctCount;
    private final int prize;
    private final boolean hasBonus;
    private final BiPredicate<Integer, Boolean> predicate;

    Rank(int correctCount, int prize, boolean hasBonus,
         BiPredicate<Integer, Boolean> predicate) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
        this.predicate = predicate;
    }

    public static Rank find(int count, boolean isBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.predicate.test(count, isBonus))
                .findFirst()
                .orElse(NONE);
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
