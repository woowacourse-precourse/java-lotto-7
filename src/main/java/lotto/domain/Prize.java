package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "낙첨");

    private final int matchCount;
    private final boolean matchBonus;
    private final long prizeAmount;
    private final String description;

    Prize(int matchCount, boolean matchBonus, long prizeAmount, String description) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public static Prize from(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(prize -> !prize.matchBonus)  // 2등(보너스 볼)은 이미 처리했으므로 제외
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    @Override
    public String toString() {
        if (this == NONE) {
            return description;
        }
        return String.format("%s (%,d원)", description, prizeAmount);
    }
}
