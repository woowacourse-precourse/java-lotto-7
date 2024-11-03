package lotto.handler.rank.dto;

public class WinningNumberDTO {
    private String winningNumbers;
    private String bonusNumber;

    private WinningNumberDTO(String winningNumbers, String bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumberDTO create(String winningNumbers, String bonusNumber) {
        return new WinningNumberDTO(winningNumbers, bonusNumber);
    }
}
