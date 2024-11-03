package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    static Map<String, Integer> LottoRankCollector() {
        Map<String, Integer> rankCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank.name(), 0); // 초기값 설정
        }
        return rankCounts;
    }

    public int getPrize() {
        return prize;
    }


    public int getMatchCount() {
        return matchCount;
    }

    public static String valueOf(int matchCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                if (matchCount == 5 && matchBonus == false) {
                    return "THIRD";
                }
                if (matchCount == 5 && matchBonus == true) {
                    return "SECOND";
                }
                return rank.name();
            }

        }
        return "NONE";
    }
}

