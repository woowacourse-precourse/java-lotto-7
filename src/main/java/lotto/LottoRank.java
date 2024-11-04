package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int matchCount;
    private final boolean bonusMatched;
    private final int prizeAmount;
    private int count = 0;

    LottoRank(int matchCount, boolean bonusMatched, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prizeAmount = prizeAmount;
    }

    public static List<LottoRank> valuesList() {
        List<LottoRank> ranks = new ArrayList<>(EnumSet.allOf(LottoRank.class));
        Collections.reverse(ranks);
        return ranks;
    }

    public static void setLottoRank(int matchCount, boolean bonusMatched) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchCount && rank.bonusMatched == bonusMatched) {
                rank.count++;
                return;
            }
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatched() {
        return bonusMatched;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getCount() {
        return count;
    }

    public static void init() {
        for (LottoRank rank : LottoRank.values()) {
            rank.count = 0;
        }
    }
}
