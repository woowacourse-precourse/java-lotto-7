package lotto.model.lotto;

public class LottoResult {

    private final int matchingCount;
    private final boolean hasBonus;

    public LottoResult(int matchingCount, boolean hasBonus) {
        this.matchingCount = matchingCount;
        this.hasBonus = hasBonus;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

}
