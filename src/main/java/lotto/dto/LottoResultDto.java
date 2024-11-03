package lotto.dto;

public class LottoResultDto {
    private final int matchCount;
    private final long money;
    private final int winnerCount;
    private final boolean isBonusMatch;

    public LottoResultDto(int matchCount, long money, int winnerCount, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.money = money;
        this.winnerCount = winnerCount;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }

    public int getWinnerCount() {
        return winnerCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
}
