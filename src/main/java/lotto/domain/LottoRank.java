package lotto.domain;

import static lotto.constant.LottoValueConstant.NON_RANK;
import static lotto.constant.LottoValueConstant.SECOND_RANK;

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

    public static Map<String, Integer> LottoRankCollector() {
        Map<String, Integer> rankCounts = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank.name(), 0);
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
        if (isSecondRank(matchCount, matchBonus)) {
            return SECOND_RANK;
        }
        return getRankNameByMatchCount(matchCount);
    }

    private static boolean isSecondRank(int matchCount, boolean matchBonus) {
        return matchCount == 5 && matchBonus;
    }

    private static String getRankNameByMatchCount(int matchCount) {
        for (LottoRank rank : values()) {
            if (matchCount == rank.matchCount) {
                return rank.name();
            }
        }
        return NON_RANK;
    }
}

