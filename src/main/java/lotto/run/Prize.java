package lotto.run;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Prize {
    FIRST(6, 2_000_000_000L, "6개 일치"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 일치"),
    THIRD(5, 1_500_000L, "5개 일치"),
    FOURTH(4, 50_000L, "4개 일치"),
    FIFTH(3, 5_000L, "3개 일치"),
    NO_PRIZE(0, 0L, "3개 미만 일치");

    private final int matchCount;
    private final long prizeNum;
    private final String displayName;

    Prize(int matchCount, long prizeNum, String displayName) {
        this.matchCount = matchCount;
        this.prizeNum = prizeNum;
        this.displayName = displayName;
    }

    public static Map<Prize, Integer> getPrizeCount() {
        Map<Prize, Integer> prizeCountMap = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0);
        }
        return prizeCountMap;
    }

    public static Prize getPrize(int matchCount, boolean isBonusMatched) {
        if (matchCount == 6) {
            return Prize.FIRST;
        } else if (matchCount == 5 && isBonusMatched) {
            return Prize.SECOND;
        } else if (matchCount == 5) {
            return Prize.THIRD;
        } else if (matchCount == 4) {
            return Prize.FOURTH;
        } else if (matchCount == 3) {
            return Prize.FIFTH;
        } else {
            return Prize.NO_PRIZE;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeNum() {
        return prizeNum;
    }

    public String getDisplayName() {
        return displayName;
    }
}