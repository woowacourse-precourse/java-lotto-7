package lotto.vo;

public class WinningConditions {
    private final int winningNumbers;
    private final int winningBonus;
    private final int prizeMoney;

    public WinningConditions(int winningNumbers, int winningBonus, int prizeMoney) {
        this.winningNumbers = winningNumbers;
        this.winningBonus = winningBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getWinningNumbersConditions() {
        return winningNumbers;
    }

    public int getWinningBonusCondition() {
        return winningBonus;
    }

    public int match(int inputMainNumbers, int inputBonusNumber) {
        if (winningNumbers == inputMainNumbers && winningBonus == inputBonusNumber) {
            return prizeMoney;
        }
        if (winningNumbers == inputBonusNumber) {
            return prizeMoney;
        }
        return 0;
    }
}
