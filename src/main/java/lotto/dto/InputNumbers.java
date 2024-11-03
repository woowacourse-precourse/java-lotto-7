package lotto.dto;

import java.util.List;

public class InputNumbers {
    private final List<Integer> mainNumbers;
    private final int bonusNumber;

    public InputNumbers(List<Integer> mainNumbers, int bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
