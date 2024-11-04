package lotto.model.lotto.lottoNumber;

import java.util.Collections;
import java.util.List;
import lotto.model.validator.LotteryNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LotteryNumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public int checkMatchingAmountWith(List<Integer> numbers) {
        int matchingAmount = 0;
        for (int number : numbers) {
            if (contains(number)) {
                matchingAmount++;
            }
        }
        return matchingAmount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
