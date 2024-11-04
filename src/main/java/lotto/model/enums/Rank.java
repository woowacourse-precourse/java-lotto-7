package lotto.model.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000L, "6개 일치"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000L, "5개 일치"),
    FOURTH(4, 50_000L, "4개 일치"),
    FIFTH(3, 5_000L, "3개 일치"),
    NO_PRIZE(0, 0L, "3개 미만 일치");

    private final int matchCount;
    private final long prizeAmount;
    private final String displayName;

    Rank(int matchCount, long prizeAmount, String displayName) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.displayName = displayName;
    }

    public static Map<Rank, Integer> getRankCountMap() {
        Map<Rank, Integer> rankCountMap = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0); // 기본값 0으로 초기화
        }
        return rankCountMap;
    }

    public static Rank getRank(int matchCount, boolean isBonusMatched) {
        if (matchCount == 6) {
            return Rank.FIRST;
        } else if (matchCount == 5 && isBonusMatched) {
            return Rank.SECOND;
        } else if (matchCount == 5) {
            return Rank.THIRD;
        } else if (matchCount == 4) {
            return Rank.FOURTH;
        } else if (matchCount == 3) {
            return Rank.FIFTH;
        } else {
            return Rank.NO_PRIZE;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getDisplayName() {
        return displayName;
    }
}
