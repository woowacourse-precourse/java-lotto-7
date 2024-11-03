package lotto.domain;

public class LottoCount {
    private final int matchCount;
    private final boolean hasBonusNumber;

    public LottoCount(int matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }
}
