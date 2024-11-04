package lotto.domain.dto;

public class LottoResultDto {
    private final int winningNumber;
    private final boolean isBonus;


    public LottoResultDto(int winningNumber, boolean isBonus) {
        this.winningNumber = winningNumber;
        this.isBonus = isBonus;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public boolean getIsBonus() {
        return isBonus;
    }
}
