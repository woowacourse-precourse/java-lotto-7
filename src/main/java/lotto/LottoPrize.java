package lotto;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public enum LottoPrize {

    FIRST(6, false, 2_000_000_000, (matchCount, hasBonusNumber) ->  matchCount == 6),
    SECOND(5, true, 30_000_000, (matchCount, hasBonusNumber) ->  matchCount == 5 && hasBonusNumber),
    THIRD(5, false, 1_500_000, (matchCount, hasBonusNumber) ->  matchCount == 5 && !hasBonusNumber),
    FOURTH(4, false, 50_000, (matchCount, hasBonusNumber) ->  matchCount == 4),
    FIFTH(3, false, 5_000, (matchCount, hasBonusNumber) ->  matchCount == 3),
    NONE(0, false, 0, (matchCount, hasBonusNumber) ->  false);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final long prize;
    private final BiPredicate<Long, Boolean> winningCondition;

    LottoPrize(int matchCount, boolean hasBonusNumber, long prize, BiPredicate<Long, Boolean> winningCondition) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
        this.winningCondition = winningCondition;
    }

    public static LottoPrize findLottoPrizeBy(long matchCount, boolean hasBonusNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.winningCondition.test(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }

    public long getPrize() {
        return prize;
    }
}
