package lotto.constants;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Ranking {
    FIRST(6, 2_000_000_000, (count, isBonus) -> count == 6),
    SECOND(5, 30_000_000, (count, isBonus) -> count == 5 && isBonus),
    THIRD(5, 1_500_000, (count, isBonus) -> count == 5 && !isBonus),
    FOURTH(4, 50_000, (count, isBonus) -> count == 4),
    FIFTH(3, 5_000, (count, isBonus) -> count == 3),
    NONE(0, 0, (count, isBonus) -> count < 3);

    private final int matchCount;
    private final long reward;
    private final BiPredicate<Integer, Boolean> isMatchFunction;

    Ranking(int matchCount, long reward, BiPredicate<Integer, Boolean> isMatchFunction) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.isMatchFunction = isMatchFunction;
    }

    public static Ranking of(int matchCount, boolean isBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount, isBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int count, boolean isBonus) {
        return isMatchFunction.test(count, isBonus);
    }

    public boolean isSecond() {
        return this.equals(SECOND);
    }


    public int getMatchCount() {
        return matchCount;
    }

    public long getReward() {
        return reward;
    }
}