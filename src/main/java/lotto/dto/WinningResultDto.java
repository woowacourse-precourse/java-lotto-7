package lotto.dto;

public class WinningResultDto {

    private final Integer winningScore;
    private final boolean isBonusMatched;

    public WinningResultDto(Integer winningScore, boolean isBonusMatched) {
        this.winningScore = winningScore;
        this.isBonusMatched = isBonusMatched;
    }

    public Integer getWinningScore() {
        return winningScore;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }
}
