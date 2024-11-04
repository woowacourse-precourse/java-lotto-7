package lotto.domain;

import java.util.Arrays;

public enum LottoMatchType {
    NONE(0, false, 0),
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int matchCount;
    private final boolean bonus;
    private final int winningPrice;

    LottoMatchType(int matchCount, boolean bonus, int winningPrice) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.winningPrice = winningPrice;
    }

    public static LottoMatchType getType(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(matchType ->matchType.matchCount == matchCount)
                .filter(matchType -> matchType.bonus == bonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 타입이 없음"));
    }

    public boolean hasBonus() {
        return bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public long getProfit(int count) {
        return (long) winningPrice * count;
    }
}
