package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "%d개 일치 (%s원) - %d개"),
    SECOND(5, true, 30_000_000, "%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    THIRD(5, false, 1_500_000, "%d개 일치 (%s원) - %d개"),
    FOURTH(4, false, 50_000, "%d개 일치 (%s원) - %d개"),
    FIFTH(3, false, 5_000, "%d개 일치 (%s원) - %d개"),
    MISS(0, false, 0, "");

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;
    private final String format;

    Rank(int matchCount, boolean requiresBonus, int prize, String format) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
        this.format = format;
    }

    public static Rank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && (!rank.requiresBonus || matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    public String getFormattedResult(int count) {
        if (this == MISS) return "";  // MISS는 출력하지 않음
        return String.format(format, matchCount, formatPrize(prize), count);
    }

    public int getPrize() {
        return prize;
    }


    private static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

}
