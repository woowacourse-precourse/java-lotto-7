package lotto.dto;

import lotto.Utils.Convertor;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> selectedNumbers;
    private final int bonusNumber;

    public WinningNumbers(String selectedNumbers, int bonusNumber) {
        this.selectedNumbers = Convertor.convert(selectedNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
