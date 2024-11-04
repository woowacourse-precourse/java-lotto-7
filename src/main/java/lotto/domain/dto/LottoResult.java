package lotto.domain.dto;

public class LottoResult {
    private final int matchingNumberCount;
    private final boolean bonusMatch;

    public LottoResult(int matchingNumberCount, boolean bonusMatch) {
        this.matchingNumberCount = matchingNumberCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
