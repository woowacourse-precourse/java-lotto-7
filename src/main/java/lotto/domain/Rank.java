package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST_PLACE(6, 2_000_000_000, (matchCount, hasBonus) -> matchCount == 6),
    SECOND_PLACE(5, 30_000_000, (matchCount, hasBonus) -> matchCount == 5 && hasBonus),
    THIRD_PLACE(5, 1_500_000, (matchCount, hasBonus) -> matchCount == 5 && !hasBonus),
    FOURTH_PLACE(4, 50_000, (matchCount, hasBonus) -> matchCount == 4),
    FIFTH_PLACE(3, 5_000, (matchCount, hasBonus) -> matchCount == 3),
    MISS(0, 0, (matchCount, hasBonus) -> matchCount < 3);

    private final int matchCount;
    private final int prize;
    private final BiPredicate<Integer, Boolean> matchCondition;

    Rank(int matchCount, int prize, BiPredicate<Integer, Boolean> matchCondition) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchCondition = matchCondition;
    }

    public static Rank of(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCondition.test(matchCount, hasBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getPrize() {
        return prize;
    }
}