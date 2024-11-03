package constant;

import java.text.NumberFormat;

public enum Rank {
    FIRST_RANK(6, false, 2000000000),
    SECOND_RANK(5, true, 30000000),
    THIRD_RANK(5, false, 1500000),
    FORTH_RANK(4, false, 50000),
    FIFTH_RANK(3, false, 5000),
    UN_RANK(0, false, 0);
    private final Integer matchCount;
    private final boolean bonusNumberMatch;
    private final Integer rankPrize;

    Rank(Integer matchCount, boolean bonusNumberMatch, Integer rankPrize) {
        this.matchCount = matchCount;
        this.bonusNumberMatch = bonusNumberMatch;
        this.rankPrize = rankPrize;
    }

    public String showRankCondition() {
        if (!this.bonusNumberMatch) {
            return matchCount + "개 일치" + " (" + NumberFormat.getInstance().format(rankPrize) + ") - ";
        }
        return matchCount + "개 일치" + ",보너스 볼 일치 " + " (" + NumberFormat.getInstance().format(rankPrize) + ") -";
    }

    public boolean checkRank(Integer matchNumber, boolean bonusNumberMatch) {
        if (this.bonusNumberMatch) {
            return matchNumber.equals(this.matchCount) && bonusNumberMatch;
        }
        return matchNumber.equals(this.matchCount);
    }

}
