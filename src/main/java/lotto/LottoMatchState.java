package lotto;

import java.util.Arrays;

public enum LottoMatchState {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int matchCount;
    private final boolean bonus;
    private final int money;

    LottoMatchState(int matchCount, boolean bonus, int money) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.money = money;
    }

    public static LottoMatchState getMatchState(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(matchState -> (matchState.matchCount == matchCount) && (matchState.bonus == bonus))
                .findFirst()
                .orElseThrow();
    }

    public int getMoney() {
        return money;
    }
}
