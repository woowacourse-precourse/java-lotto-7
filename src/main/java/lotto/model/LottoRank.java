package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    NONE(0, 0, "낙첨", false),
    FIFTH(3, 5000, "5등", false),
    FOURTH(4, 50000, "4등", false),
    THIRD(5, 1500000, "3등", false),
    SECOND(5, 30000000, "2등", true),
    FIRST(6, 2000000000, "1등", false);

    private final int matchCount;
    private final int prize;
    private final String rankName;
    private final boolean isBonusRequired;

    LottoRank(int matchCount, int prize, String rankName, boolean isBonusRequired) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.rankName = rankName;
        this.isBonusRequired = isBonusRequired;
    }

    public static LottoRank calculateRank(int matchCount, boolean isBonusCorrect) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && isBonusCorrect) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public static List<LottoRank> getAllRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != NONE)
                .toList();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getRankName() {
        return rankName;
    }

    public boolean isBonusRequired() {
        return isBonusRequired;
    }
}
