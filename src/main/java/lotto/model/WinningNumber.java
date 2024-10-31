package lotto.model;

import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumber() {
        this.numbers = null;
        this.bonusNumber = 0;
    }

    public void updateNumbersAndBonusNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
