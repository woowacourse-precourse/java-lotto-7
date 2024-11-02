package lotto.domain.vo;

import static lotto.view.OutputMessage.*;

import java.util.Arrays;

public enum WinningRank {
    FIFTH(3, false, 5_000, "3개"),
    FOURTH(4, false, 50_000, "4개"),
    THIRD(5, false, 1_500_000, "5개"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼"),
    FIRST(6, false, 2_000_000_000, "6개"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int prizeMoney;
    private final String matchDescription;

    WinningRank(int matchCount, boolean isBonusMatch, int prizeMoney, String matchDescription) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prizeMoney = prizeMoney;
        this.matchDescription = matchDescription;
    }

    public String getWinningMessage(int count) {
        return String.format(MATCH_RESULT.getMessage(),
            matchDescription,
            prizeMoney,
            count);
    }

    public static WinningRank of(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return SECOND;
        }

        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount && !rank.isBonusMatch)
            .findFirst()
            .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}