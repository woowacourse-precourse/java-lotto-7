package lotto.model;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber,WinningNumbers winningNumbers) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber,WinningNumbers winningNumbers) {
        return new BonusNumber(bonusNumber,winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
