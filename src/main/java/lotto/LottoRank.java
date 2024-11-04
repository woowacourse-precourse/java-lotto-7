package lotto;

import java.util.List;

public class LottoRank {
    public static final LottoRank FIRST = new LottoRank(6, false, 2000000000);
    public static final LottoRank SECOND = new LottoRank(5, true, 30000000);
    public static final LottoRank THIRD = new LottoRank(5, false, 1500000);
    public static final LottoRank FOURTH = new LottoRank(4, false, 50000);
    public static final LottoRank FIFTH = new LottoRank(3, false, 5000);
    public static final LottoRank NONE = new LottoRank(0, false, 0);
    private final int matchCount;
    private final boolean bonusMatched;
    private final int prizeAmount;
    private int count = 0;
    public static final List<LottoRank> VALUES = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    LottoRank(int matchCount, boolean bonusMatched, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank getLottoRank(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) {
            FIRST.count++;
            return FIRST;
        } else if (matchCount == 5 && bonusMatched) {
            SECOND.count++;
            return SECOND;
        } else if (matchCount == 5) {
            THIRD.count++;
            return THIRD;
        } else if (matchCount == 4) {
            FOURTH.count++;
            return FOURTH;
        } else if (matchCount == 3) {
            FIFTH.count++;
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchCount() { return matchCount; }

    public boolean getBonusMatched() {
        return bonusMatched;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getCount() {
        return count;
    }
}
