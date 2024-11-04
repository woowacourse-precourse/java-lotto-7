package lotto.common;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoResults {
    FIRST(6, false, 2000000000, "6개 일치"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1500000, "5개 일치"),
    FORTH(4, false, 50000, "4개 일치"),
    FIFTH(3, false, 5000, "3개 일치"),
    NONE(-1, false, 0, "없음");

    private final int matchedCount;
    private final boolean bonusNumberMatched;
    private final BigDecimal winningAmount;
    private final String conditionInformation;

    LottoResults(final int matchedCount, final boolean bonusNumberMatched, final int winningAmount, final String conditionInformation) {
        this.matchedCount = matchedCount;
        this.bonusNumberMatched = bonusNumberMatched;
        this.winningAmount = new BigDecimal(winningAmount);
        this.conditionInformation = conditionInformation;
    }

    public BigDecimal getWinningAmount() {
        return this.winningAmount;
    }

    public static LottoResults getWinningStatus(final int matchedCount, final boolean bonusNumberMatched) {
        return Arrays.stream(LottoResults.values())
                .filter(resultStatus -> matchedCount == resultStatus.matchedCount && bonusNumberMatched == resultStatus.bonusNumberMatched)
                .findAny()
                .orElse(LottoResults.NONE);
    }

    public String getConditionInformation() {
        return this.conditionInformation;
    }
}
