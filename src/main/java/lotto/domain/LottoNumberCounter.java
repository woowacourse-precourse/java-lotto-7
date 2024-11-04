package lotto.domain;

public class LottoNumberCounter {
    private int matchingNumberCount;
    private int bonusNumberCount;

    LottoNumberCounter(int matchingNumberCount, int bonusNumberCount) {
        this.matchingNumberCount = matchingNumberCount;
        this.bonusNumberCount = bonusNumberCount;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getBonusNumberCount() {
        return bonusNumberCount;
    }
}
