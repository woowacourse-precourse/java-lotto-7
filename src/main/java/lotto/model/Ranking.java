package lotto.model;

import lotto.dto.MatchInfo;

import java.util.Arrays;

import static lotto.Exception.ExceptionMessage.*;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    SIXTH(2,0),
    SEVENTH(1,0),
    MISS(0,0);

    private final int matchCount;
    private final int prizeMoney;

    Ranking(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Ranking calculateRanking(MatchInfo matchInfo) {
        if (matchInfo.matchCount() == SECOND.matchCount && matchInfo.isMatchBonusNumber()) {
            return SECOND;
        }

        if (matchInfo.matchCount() < MISS.matchCount) {
            return MISS;
        }

        return Arrays.stream(values())
                .filter(ranking -> ranking.matchCount == matchInfo.matchCount())
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ZERO_MATCH.getMessage()));
    }

    public long getPrizeMoney(int winningCount) {
        return (long) this.prizeMoney * winningCount;
    }
}
