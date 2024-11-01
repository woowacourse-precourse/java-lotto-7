package lotto.rule;

import java.util.Arrays;
import java.util.List;

public enum Prize {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NO_LUCK(0, false, 0),
    ;

    private final int matchesCount;
    private final boolean isBonusMatches;
    private final long prizeAmount;

    Prize(int matchesCount, boolean isBonusMatches, long prizeAmount) {
        this.matchesCount = matchesCount;
        this.isBonusMatches = isBonusMatches;
        this.prizeAmount = prizeAmount;
    }

    public static Prize getPrizeByMatchInfo(int matchesCount, boolean isBonusMatches) {
        List<Prize> prizes = Arrays.stream(values())
                .filter(prize -> prize.matchesCount == matchesCount)
                .filter(prize -> prize.isBonusMatches == isBonusMatches)
                .toList();

        if (prizes.isEmpty()) {
            return NO_LUCK;
        }
        return prizes.getLast();
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}
