package lotto.entity;

import java.util.List;
import lotto.validator.WinningNumbersValidator;

public class WinningNumbers {
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> mainNumbers, int bonusNumber) {
        WinningNumbersValidator.validate(mainNumbers, bonusNumber);
        this.mainNumbers = new Lotto(mainNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return mainNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
