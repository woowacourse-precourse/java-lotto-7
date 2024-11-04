package lotto.model.winningNumber;

import java.util.Collections;
import java.util.List;
import lotto.model.validator.LotteryNumberValidator;

public record MainNumber(List<Integer> numbers) {

    public MainNumber {
        LotteryNumberValidator.validate(numbers);
    }

    public boolean contains(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }
}
