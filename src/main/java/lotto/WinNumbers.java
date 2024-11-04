package lotto;

import java.util.List;

public class WinNumbers {

    private final List<Integer> WinNumbers;
    private final int bonusNumber;

    public WinNumbers(List<Integer> winNumbers, int bonusNumber) {
        Validator.validateWinNumber(winNumbers);
        Validator.validateBonusNumber(winNumbers, bonusNumber);
        this.WinNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinNumbers() {
        return WinNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
