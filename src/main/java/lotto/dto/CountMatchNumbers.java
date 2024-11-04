package lotto.dto;

public class CountMatchNumbers {
    private final int winningNumbers;
    private final int winningBonusNumber;

    public CountMatchNumbers(int winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public int getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }

}
