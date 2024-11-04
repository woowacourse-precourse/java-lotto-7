package lotto.dto;

public class CalculateResultDto {
    private int winningNumberMatchCount = 0;
    private int bonusNumberMatchCount = 0;

    public void plusWinningNumberMatchCount() {
        winningNumberMatchCount++;
    }

    public void plusBonusNumberMatchCount() {
        bonusNumberMatchCount++;
    }

    public int getWinningNumberMatchCount() {
        return this.winningNumberMatchCount;
    }

    public int getBonusNumberMatchCount() {
        return this.bonusNumberMatchCount;
    }
}
