package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Prize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = lotto.matchNumbers(winningNumber);
        boolean isMatchBonusNumber = lotto.matchBonusNumber(bonusNumber);

        if (matchCount == 5 && isMatchBonusNumber) {
            return Prize.SECOND;
        }

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(Prize.NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}