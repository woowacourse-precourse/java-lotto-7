package lotto.domain;

import java.util.Map;
import java.util.HashMap;

public enum LottoRank {

    THREE_MATCHES(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCHES(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCHES(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_MATCHES_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCHES(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    NON_MATCHES(0, 0, "일치 없음");

    private final int matchCount;
    private final int prize;
    private final String description;

    // 사전 초기화된 매핑
    private static final Map<Integer, LottoRank> RANK_MAP = initializeRankMap();

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    // 초기화 메서드
    private static Map<Integer, LottoRank> initializeRankMap() {
        Map<Integer, LottoRank> rankMap = new HashMap<>();
        for (LottoRank rank : values()) {
            if (rank != FIVE_MATCHES_WITH_BONUS) {
                rankMap.put(rank.matchCount, rank);
            }
        }
        return rankMap;
    }

    public static LottoRank findByMatchAndBonus(int matchCount, boolean bonusMatched) {
        if (matchCount == 5 && bonusMatched) {
            return FIVE_MATCHES_WITH_BONUS;
        }
        return RANK_MAP.getOrDefault(matchCount, NON_MATCHES);
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

}
