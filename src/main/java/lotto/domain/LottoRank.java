package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, "낙첨", 0, false),
    FIFTH(3, "3개 일치", 5_000, false),
    FOURTH(4, "4개 일치", 50_000, false),
    THIRD(5, "5개 일치", 1_500_000, false),
    SECOND(5, "5개 일치, 보너스 볼 일치", 30_000_000, true),
    FIRST(6, "6개 일치", 2_000_000_000, false);

    private final int matchCount;
    private final String description;
    private final int reward;
    private final boolean hasBonusMatch;

    LottoRank(int matchCount, String description, int reward, boolean hasBonusMatch) {
        this.matchCount = matchCount;
        this.description = description;
        this.reward = reward;
        this.hasBonusMatch = hasBonusMatch;
    }

    public static LottoRank findRank(int matchCount, boolean hasBonusMatch) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .filter(lottoRank -> lottoRank.hasBonusMatch == hasBonusMatch)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }
}
