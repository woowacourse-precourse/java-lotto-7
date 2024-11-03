package lotto.common;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoResult {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FORTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(-1, false, 0);

    private final int matchedCount;
    private final boolean bonusNumberMatched;
    private final BigDecimal winningAmount;

    LottoResult(final int matchedCount, final boolean bonusNumberMatched, final int winningAmount) {
        this.matchedCount = matchedCount;
        this.bonusNumberMatched = bonusNumberMatched;
        this.winningAmount = new BigDecimal(winningAmount);
    }

    public BigDecimal getWinningAmount() {
        return this.winningAmount;
    }

    public static LottoResult getWinningStatus(final int matchedCount, final boolean bonusNumberMatched) {
        return Arrays.stream(LottoResult.values())
                .filter(resultStatus -> matchedCount == resultStatus.matchedCount && bonusNumberMatched == resultStatus.bonusNumberMatched)
                .findAny()
                .orElse(LottoResult.NONE);
    }
}
