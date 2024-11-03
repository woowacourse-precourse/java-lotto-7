package lotto.model.winning;

import java.util.List;

public class WinningNumbers {

    private final Numbers numbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = new Numbers(numbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

}
