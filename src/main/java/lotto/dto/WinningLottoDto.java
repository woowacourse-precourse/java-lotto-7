package lotto.dto;

public class WinningLottoDto {
    private long matchedNumbersCount;
    private boolean isBonusMatched;

    public WinningLottoDto(long matchedNumbersCount, boolean isBonusMatched) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.isBonusMatched = isBonusMatched;
    }

    public long getMatchedCount() {
        return this.matchedNumbersCount;
    }

    public boolean getIsBonusMatched() {
        return this.isBonusMatched;
    }
}
