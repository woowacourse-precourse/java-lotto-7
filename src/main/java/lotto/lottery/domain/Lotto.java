package lotto.lottery.domain;

import static lotto.global.util.ErrorMessage.INVALID_LOTTO_COUNT;
import static lotto.global.util.LottoConst.LOTTO_NUMBERS;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
