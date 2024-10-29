package lotto.lottery.domain;

import static lotto.global.util.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.global.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
