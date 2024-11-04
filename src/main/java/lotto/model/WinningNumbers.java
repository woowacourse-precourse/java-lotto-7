package lotto.model;

public class WinningNumbers {
    private final Lotto winNumber;
    private final int bonusNumber;

    public WinningNumbers(Lotto winNumber, int bonusNumber) {
        validateBonusNumber(winNumber, bonusNumber);
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(Lotto winNumber, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이 숫자여야 합니다.");
        }

        if (winNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    public Lotto getWinningNumber() {
        return winNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
