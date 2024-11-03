package lotto.model.lotto.lottoNumber;

import java.util.Collections;
import java.util.List;
import lotto.model.validator.LotteryNumberValidator;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        LotteryNumberValidator.validate(numbers);
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

    @Override
    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }
}
