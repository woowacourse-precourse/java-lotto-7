package lotto.model;

import lotto.enums.ExceptionMessage;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonus){
        if(winningNumbers.getNumbers().contains(bonus)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
