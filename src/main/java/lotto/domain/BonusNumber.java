package lotto.domain;

import lotto.util.ValidateNumbers;
import java.util.List;
import static lotto.message.ErrorMessage.INVALID_LOTTO_RANGE;

public class BonusNumber {
    private final int bonus;
    public BonusNumber(String bonus, List<Integer> winningNumbers){
        this.bonus = parseBonus(bonus);
        validateBonusNumber(this.bonus, winningNumbers);
    }
    private int parseBonus(String bonus){
        try{
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
    }
    private void validateBonusNumber(int bonus, List<Integer> winningNumbers){
        new ValidateNumbers(bonus, winningNumbers);
    }
    public int getBonus() {
        return bonus;
    }
}
