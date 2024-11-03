package lotto.validator;

import java.util.Set;


public class InputValidator {
    private final int amount;
    private final int bonus;
    private final Set<Integer> winningNumbers;

    public InputValidator(Amount amount, WinningNumbers winningNumbers,
            BonusNumber bonusNumber) {

        this.amount = amount.getAmount();
        this.bonus = bonusNumber.getBonusNumber();
        this.winningNumbers = winningNumbers.getWinningNumbers();

    }


    public int getAmount() {
        return amount;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

}
