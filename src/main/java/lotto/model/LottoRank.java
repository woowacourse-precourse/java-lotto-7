package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int sameNumberCount;
    private final long reward;
    private final boolean isSecondRank;

    LottoRank(int sameNumberCount, long reward, boolean isSecondRank) {
        this.sameNumberCount = sameNumberCount;
        this.reward = reward;
        this.isSecondRank = isSecondRank;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public long getReward() {
        return reward;
    }

    public boolean isSecondRank() {
        return isSecondRank;
    }

    public static LottoRank findRank(Integer sameNumberCount, Boolean isSecondRank) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.isMatched(sameNumberCount, isSecondRank))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatched(Integer sameNumberCount, Boolean isSecondRank) {
        return this.sameNumberCount == sameNumberCount
                && this.isSecondRank == isSecondRank;
    }
}
