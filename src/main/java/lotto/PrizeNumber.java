package lotto;

import java.util.List;

public class PrizeNumber {
    private final List<Integer> numbers;

    public PrizeNumber(
            List<Integer> numbers
    ) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
