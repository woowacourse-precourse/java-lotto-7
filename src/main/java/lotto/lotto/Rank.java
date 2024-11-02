package lotto.lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(150_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    private final int amount;
    private final int matchingCount;

    Rank(int amount, int matchingCount) {
        this.amount = amount;
        this.matchingCount = matchingCount;
    }

    public static Rank determine(int count, boolean isMatchBonusNumber) {
        if (isSecondRank(count, isMatchBonusNumber)) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != SECOND && rank.matchingCount == count)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isSecondRank(int count, boolean isMatchBonusNumber) {
        return count == SECOND.matchingCount && isMatchBonusNumber;
    }
}
