package lotto.common.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrizeRank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "당첨 조건에 해당 안됨");

    private final int matchCount;
    private final boolean bonusMatch;
    private final long prizeMoney;
    private final String description;

    LottoPrizeRank(int matchCount, boolean bonusMatch, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static LottoPrizeRank getLottoPrizeRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public static List<LottoPrizeRank> getWinningRanks() {
        return Arrays.stream(values())
                .filter(rank -> rank != NONE)
                .collect(Collectors.toList());
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}