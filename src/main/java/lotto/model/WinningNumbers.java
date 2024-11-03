package lotto.model;

import java.util.List;

public class WinningNumbers {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
