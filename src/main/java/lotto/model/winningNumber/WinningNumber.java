package lotto.model.winningNumber;

import java.util.Collections;
import java.util.List;
import lotto.model.validator.LotteryNumberValidator;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        LotteryNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
