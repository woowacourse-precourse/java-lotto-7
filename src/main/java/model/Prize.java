package model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    ZERO(0, 0,
        (matchCount, containBonusNumber) -> matchCount < 3),
    FIRST(2_000_000_000, 6,
        (matchCount, containBonusNumber) -> matchCount == 6),
    SECOND(30_000_000, 5,
        (matchCount, containBonusNumber) -> matchCount == 5 && containBonusNumber),
    THIRD(1_500_000, 5,
        (matchCount, containBonusNumber) -> matchCount == 5 && !containBonusNumber),
    FOURTH(50_000, 4,
        (matchCount, containBonusNumber) -> matchCount == 4),
    FIFTH(5_000, 3,
        (matchCount, containBonusNumber) -> matchCount == 3);
    private final int money;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> isContain;

    Prize(int money, int matchCount, BiPredicate<Integer, Boolean> isContain) {
        this.money = money;
        this.matchCount = matchCount;
        this.isContain = isContain;
    }

    public static Prize getPrize(int matchCount, boolean contatinBonusNumber) {
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.isContain.test(matchCount, contatinBonusNumber))
            .findAny()
            .orElse(ZERO);
    }

    public int getMoney() {
        return this.money;
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}
