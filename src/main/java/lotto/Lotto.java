package lotto;

import static lotto.global.constant.Config.LOTTO_NUMBER_SIZE;
import static lotto.global.constant.ErrorMessage.LOTTO_NUMBER_OUT_OF_SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_SIZE);
        }
    }

}
