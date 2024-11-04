package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "");

    public final int matchCount;
    public final boolean matchBonus;
    public final int prize;
    public final String matchMessage;

    Rank(int matchCount, boolean matchBonus, int prize, String matchMessage) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.matchMessage = matchMessage;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && !rank.matchBonus && rank != SECOND) {
                return rank;
            }
        }
        return NONE;
    }

    public static List<Rank> getWinningRanks() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public int getPrize() {
        return prize;
    }

    public String getMatchMessage() {
        return matchMessage;
    }
}

