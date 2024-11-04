package lotto.model;

public class LottoResult {
    private final int matchedNumberCount;
    private final boolean hasBonusNumber;

    public LottoResult(int matchedNumberCount, boolean hasBonusNumber) {
        this.matchedNumberCount = matchedNumberCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
