package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, 0L, false),
    FIFTH(3, 5000L, false),
    FOURTH(4, 50000L, false),
    THIRD(5, 1500000L, false),
    SECOND(5, 30000000L, true),
    FIRST(6, 2000000000L, false);

    private final Integer sameNumberCount;
    private final Long profit;
    private final Boolean isSecondRank;

    LottoRank(Integer sameNumberCount, Long profit, Boolean isSecondRank) {
        this.sameNumberCount = sameNumberCount;
        this.profit = profit;
        this.isSecondRank = isSecondRank;
    }

    public Integer getSameNumberCount() {
        return sameNumberCount;
    }

    public Long getProfit() {
        return profit;
    }

    public Boolean isSecondRank() {
        return isSecondRank;
    }

    public Long calculateProfitByCount(Long winningCount) {
        return profit * winningCount;
    }

    public static LottoRank findRank(Integer sameNumberCount, Boolean isSecondRank) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.isMatched(sameNumberCount, isSecondRank))
                .findFirst()
                .orElse(NONE);
    }

    private Boolean isMatched(Integer sameNumberCount, Boolean isSecondRank) {
        return this.sameNumberCount == sameNumberCount.intValue()
                && this.isSecondRank == isSecondRank;
    }
}
