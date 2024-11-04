package lotto.domain.dto;

public class WinningLottoForm {
    private String winningNumbers;
    private String bonusNumber;

    public WinningLottoForm(String winningNumbers, String bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
