package lotto;

import java.util.Arrays;

public enum LottoPrize {
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int money;

    LottoPrize(int matchCount, boolean bonusMatch, int money) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.money = money;
    }

    public static LottoPrize of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoPrize.values())
            .filter(prize -> prize.matchCount == matchCount && prize.bonusMatch == bonusMatch)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 당첨 결과가 존재하지 않습니다."));
    }

    public int getMoney() {
        return money;
    }
}
