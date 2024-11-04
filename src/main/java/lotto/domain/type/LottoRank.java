package lotto.domain.type;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    NONE(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    private static final Map<Long, LottoRank> rankMap = new HashMap<>();

    static {
        rankMap.put(3L, THREE);
        rankMap.put(4L, FOUR);
        rankMap.put(5L, FIVE);
        rankMap.put(6L, SIX);
    }

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank valueOf(long count, boolean isMatchBonus) {
        if (rankMap.containsKey(count)) {
            LottoRank rank = rankMap.get(count);

            if (rank == FIVE && isMatchBonus) {
                return FIVE_WITH_BONUS;
            }

            return rank;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        return NumberFormat.getInstance().format(prize) + "원";
    }

    public int getMatchCount() {
        return matchCount;
    }
}