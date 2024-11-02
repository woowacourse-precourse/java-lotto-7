package lotto.model;

import java.util.List;

public class LottoRank {
    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    public static final LottoRank FIRST = new LottoRank(6, false, 2000000000);
    public static final LottoRank SECOND = new LottoRank(5, true, 30000000);
    public static final LottoRank THIRD = new LottoRank(5, false, 1500000);
    public static final LottoRank FOURTH = new LottoRank(4, false, 50000);
    public static final LottoRank FIFTH = new LottoRank(3, false, 5000);
    public static final LottoRank MISS = new LottoRank(0, false, 0);

    public static final List<LottoRank> ranks = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, MISS);

    private LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoRank getRank(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }
        for (LottoRank rank : ranks) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}