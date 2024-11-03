package lotto.model;

import java.util.Arrays;

import static lotto.model.PrizeConstants.*;
import static lotto.model.lotto.LottoConstants.LOTTO_SIZE;

public enum PrizeRank {
    LOSING(0, NO_BONUS, 0),
    FIRST(LOTTO_SIZE, NO_BONUS, FIRST_PRIZE),
    SECOND(LOTTO_SIZE - 1, YES_BONUS, SECOND_PRIZE),
    THIRD(LOTTO_SIZE - 1, NO_BONUS, THIRD_PRIZE),
    FOURTH(LOTTO_SIZE - 2, NO_BONUS, FOURTH_PRIZE),
    FIFTH(LOTTO_SIZE - 3, NO_BONUS, FIFTH_PRIZE);

    private final int matchCount;
    private final boolean hasBonus;
    private final Money winningMoney;

    PrizeRank(int matchCount, boolean hasBonus, int winningMoney) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.winningMoney = new Money(winningMoney);
    }

    public static PrizeRank of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(prizeRank -> prizeRank.matches(matchCount, bonusMatch))
                .findFirst()
                .orElse(LOSING);
    }

    private boolean matches(int matchCount, boolean bonusMatch) {
        return matchCount == this.matchCount && bonusMatch == this.hasBonus;
    }

    public int getWinningMoney() {
        return winningMoney.getMoney();
    }

    public int getMatchCount() {
        return matchCount;
    }
}
