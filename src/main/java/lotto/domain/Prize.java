package lotto.domain;

import java.util.Arrays;

public enum Prize {

    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonusNumber;
    private final int prizeMoney;

    Prize(int matchCount, boolean matchBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize findPrize(int matchCount, boolean matchBonus) {
        return Arrays.stream(Prize.values())
                .filter(p -> matchPrize(p, matchCount, matchBonus))
                .findAny()
                .orElse(Prize.NOTHING);
    }

    private static boolean matchPrize(Prize prize, int matchCount, boolean matchBonus) {
        if (prize.getMatchCount() != matchCount) {
            return false;
        }

        if (matchCount == 5) {
            return prize.isMatchBonusNumber() == matchBonus;
        }

        return true;
    }
}
