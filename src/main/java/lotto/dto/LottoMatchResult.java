package lotto.dto;

public class LottoMatchResult {

    int matchCount;
    Boolean bonusMatch;

    public LottoMatchResult(int matchCount, Boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Boolean getBonusMatch() {
        return bonusMatch;
    }
}
