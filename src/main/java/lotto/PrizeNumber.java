package lotto;

import java.util.List;

public class PrizeNumber {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public PrizeNumber(
            List<Integer> numbers,
            Integer bonusNumber
    ) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
