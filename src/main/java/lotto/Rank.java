package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    ZERO(0, false, 0);

    private long matchCount;
    private boolean matchBonus;
    private int prize;

    Rank(long matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static int getPrize(Rank rank) {
        return rank.prize;
    }

    public static String getRankInfo(Rank rank) {
        return rank.matchCount + "개 일치 (" + String.format("%,d", rank.prize) + "원)";
    }

    public static Rank findRank(long matchCount, boolean matchBonus) {
        return Arrays.stream(values()).filter(v -> v.matchCount == matchCount && v.matchBonus == matchBonus)
                .findFirst()
                .orElse(ZERO);
    }
}
