package lotto.enums;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),  // 보너스 번호 일치 필요
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean requiresBonus;

    Prize(int matchCount, int prizeMoney) {
        this(matchCount, prizeMoney, false);
    }

    Prize(int matchCount, int prizeMoney, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.requiresBonus = requiresBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getFormattedPrizeMoney() {
        return NumberFormat.getNumberInstance(Locale.US).format(prizeMoney);
    }

    public String getDescription(long count) {
        return requiresBonus
                ? NotificationMessage.MATCH_COUNT_WITH_BONUS.format(matchCount, getFormattedPrizeMoney(), count)
                : NotificationMessage.MATCH_COUNT_NO_BONUS.format(matchCount, getFormattedPrizeMoney(), count);
    }

    public static Prize valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount && (!prize.requiresBonus || bonusMatch))
                .findFirst()
                .orElse(NONE);
    }
}
