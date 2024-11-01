package lotto.model;

import lotto.enums.ExceptionMessage;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private  int bonus;

    public WinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus){
        if(winningNumbers.getNumbers().contains(bonus)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }
}
